import React, { useState, useEffect } from 'react';
import { fetchAPI } from '../../services/api';
import { getCurrentUser } from '../../services/auth';

const ParticipantDashboard = () => {
  const [talents, setTalents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showForm, setShowForm] = useState(false);
  const [formData, setFormData] = useState({
    title: '',
    description: '',
    videoURL: '',
    status: 'OPEN'
  });
  const user = getCurrentUser();

  useEffect(() => {
    const loadTalents = async () => {
      try {
        const data = await fetchAPI('talent/');
        setTalents(data.filter(t => t.user_id.user_id === user.user_id));
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    loadTalents();
  }, [user.user_id]);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetchAPI('talent/create', 'POST', {
        ...formData,
        user_id: { user_id: user.user_id }
      });
      
      setTalents([...talents, response]);
      setShowForm(false);
      setFormData({
        title: '',
        description: '',
        videoURL: '',
        status: 'OPEN'
      });
    } catch (err) {
      setError(err.message);
    }
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div className="error">Error: {error}</div>;

  return (
    <div className="dashboard">
      <h2>Participant Dashboard</h2>
      <button onClick={() => setShowForm(!showForm)}>
        {showForm ? 'Hide Form' : 'Add New Talent'}
      </button>

      {showForm && (
        <div className="form-container">
          <h3>Add Talent</h3>
          <form onSubmit={handleSubmit}>
            <input
              name="title"
              placeholder="Title"
              value={formData.title}
              onChange={handleChange}
              required
            />
            <textarea
              name="description"
              placeholder="Description"
              value={formData.description}
              onChange={handleChange}
              required
            />
            <input
              name="videoURL"
              type="url"
              placeholder="Video URL"
              value={formData.videoURL}
              onChange={handleChange}
              required
            />
            <button type="submit">Submit</button>
          </form>
        </div>
      )}

      <div className="list-container">
        <h3>Your Talents</h3>
        {talents.length === 0 ? (
          <p>No talents submitted yet</p>
        ) : (
          <ul>
            {talents.map(talent => (
              <li key={talent.talent_id}>
                <h4>{talent.title}</h4>
                <p>{talent.description}</p>
                <a href={talent.videoURL} target="_blank" rel="noopener noreferrer">
                  Watch Video
                </a>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
};

export default ParticipantDashboard;