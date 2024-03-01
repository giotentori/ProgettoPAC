import React from 'react';
import Home from './pages/Home';
import Products from './pages/Products';
import Login from './pages/Login';
import Register from './pages/Register';


import { BrowserRouter as Router,Route, Routes } from 'react-router-dom'


function App() {
  return (
    <Router>
      <Routes>
          <Route path="/" element={ <Home/>} />
          <Route path="/products" element={ <Products/>} />
          <Route path="/register" element={ <Register/> } />
          <Route path="/login" element={ <Login/> } />
      </Routes>
    </Router>
  );
}

export default App;
