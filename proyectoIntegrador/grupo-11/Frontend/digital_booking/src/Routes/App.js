import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { HomePage } from './Home/HomePage';
import { SignIn } from './Auth/SignIn/SignIn';
import { SignUp } from './Auth/SignUp/SignUp';



function App() {




  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
        
      </Routes>
    </BrowserRouter>

  );
}


export { App };
