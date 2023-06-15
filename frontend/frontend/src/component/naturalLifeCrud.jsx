import React, { useState } from 'react';
import './NaturalLifeCrud.css';

const NaturalLifeCrud = () => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [idToUpdate, setIdToUpdate] = useState('');
  const [idToGet, setIdToGet] = useState('');
  const [idToDelete, setIdToDelete] = useState('');
  const [response, setResponse] = useState('');
  const [showAddForm, setShowAddForm] = useState(false);
  const [showUpdateForm, setShowUpdateForm] = useState(false);
  const [showGetForm, setShowGetForm] = useState(false);
  const [showDeleteForm, setShowDeleteForm] = useState(false);

  const handleAdd = () => {
    // Perform the desired action for adding data
    setResponse('Add functionality not implemented.');
    clearForm();
  };

  const handleUpdate = () => {
    // Perform the desired action for updating data
    setResponse('Update functionality not implemented.');
    clearForm();
  };

  const handleGet = () => {
    // Perform the desired action for retrieving data
    setResponse('Get functionality not implemented.');
    clearForm();
  };

  const handleDelete = () => {
    // Perform the desired action for deleting data
    setResponse('Delete functionality not implemented.');
    clearForm();
  };

  const clearForm = () => {
    setName('');
    setDescription('');
    setIdToUpdate('');
    setIdToGet('');
    setIdToDelete('');
  };

  return (
    <div className="container">
      <h2>Add New Natural Life</h2>
      <button className="purple-button" onClick={() => setShowAddForm(!showAddForm)}>Add</button>
      {showAddForm && (
        <div className="form-container">
          <label htmlFor="name">Name:</label>
          <input type="text" id="name" value={name} onChange={(e) => setName(e.target.value)} />
          <br />
          <label htmlFor="description">Description:</label>
          <textarea id="description" value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
          <br />
          <button className="purple-button" onClick={handleAdd}>Enter</button>
        </div>
      )}

      <h2>Update Natural Life</h2>
      <button className="purple-button" onClick={() => setShowUpdateForm(!showUpdateForm)}>Update</button>
      {showUpdateForm && (
        <div className="form-container">
          <label htmlFor="updateId">ID:</label>
          <input type="text" id="updateId" value={idToUpdate} onChange={(e) => setIdToUpdate(e.target.value)} />
          <br />
          <label htmlFor="updateName">New Name:</label>
          <input type="text" id="updateName" value={name} onChange={(e) => setName(e.target.value)} />
          <br />
          <label htmlFor="updateDescription">New Description:</label>
          <textarea
            id="updateDescription"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          ></textarea>
          <br />
          <button className="purple-button" onClick={handleUpdate}>Enter</button>
        </div>
      )}

      <h2>Get Natural Life</h2>
      <button className="purple-button" onClick={() => setShowGetForm(!showGetForm)}>Get</button>
      {showGetForm && (
        <div className="form-container">
          <label htmlFor="getId">ID:</label>
          <input type="text" id="getId" value={idToGet} onChange={(e) => setIdToGet(e.target.value)} />
          <br />
          <button className="purple-button" onClick={handleGet}>Enter</button>
        </div>
      )}

      <h2>Delete Natural Life</h2>
      <button className="purple-button" onClick={() => setShowDeleteForm(!showDeleteForm)}>Delete</button>
      {showDeleteForm && (
        <div>
          <label htmlFor="deleteId">ID:</label>
          <input type="text" id="deleteId" value={idToDelete} onChange={(e) => setIdToDelete(e.target.value)} />
          <br />
          <button onClick={handleDelete}>Enter</button>
        </div>
      )}

      <div className="response">{response}</div>
    </div>
  );
};

export default NaturalLifeCrud;
