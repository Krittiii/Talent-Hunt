import React, { useState, useEffect } from 'react';
import { fetchAPI } from '../../services/api';
import { getCurrentUser } from '../../services/auth';

const JudgeDashboard = () => {
  const [comments, setComments] = useState([]);
  const [talents, setTalents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showForm, setShowForm] = useState(false);
  const [formData, setFormData] = useState({
    talent_id: '',
    score: 0,
    remark: '',
    status: 'PENDING'
  });
  const user = getCurrentUser();

  useEffect(() => {
    const loadData = async () => {
      try {
        const [commentsData, talentsData] = await Promise.all([
          fetchAPI('comment/'),
          fetchAPI('talent/')
        ]);
        
        setComments(commentsData.filter(c => c.judge_name === user.name));
        setTalents(talentsData);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    loadData();
  }, [user.name]);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetchAPI('comment/create', 'POST', {
        ...formData,
        judge_name: user.name
      });
      
      setComments([...comments, response]);
      setShowForm(false);
      setFormData({
        talent_id: '',
        score: 0,
        remark: '',
        status: 'PENDING'
      });
    } catch (err) {
      setError(err.message);
    }
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div className="error">Error: {error}</div>;

  return (
    <div className="dashboard">
      <h2>Judge Dashboard</h2>
      <button onClick={() => setShowForm(!showForm)}>
        {showForm ? 'Hide Form' : 'Add New Comment'}
      </button>

      {showForm && (
        <div className="form-container">
          <h3>Add Comment</h3>
          <form onSubmit={handleSubmit}>
            <select
              name="talent_id"
              value={formData.talent_id}
              onChange={handleChange}
              required
            >
              <option value="">Select Talent</option>
              {talents.map(talent => (
                <option key={talent.talent_id} value={talent.talent_id}>
                  {talent.title}
                </option>
              ))}
            </select>
            <input
              type="number"
              name="score"
              min="1"
              max="10"
              value={formData.score}
              onChange={handleChange}
              required
            />
            <textarea
              name="remark"
              value={formData.remark}
              onChange={handleChange}
              required
            />
            <button type="submit">Submit</button>
          </form>
        </div>
      )}

      <div className="list-container">
        <h3>Your Comments</h3>
        {comments.length === 0 ? (
          <p>No comments yet</p>
        ) : (
          <ul>
            {comments.map(comment => (
              <li key={comment.comment_id}>
                <p>Talent: {comment.talent.title}</p>
                <p>Score: {comment.score}</p>
                <p>Remark: {comment.remark}</p>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
};

export default JudgeDashboard;