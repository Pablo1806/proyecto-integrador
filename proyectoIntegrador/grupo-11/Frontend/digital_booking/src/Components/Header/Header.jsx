import React from 'react';
import './Header.css';
// impoort assets
import Logo from '../../assets/Logo/logo.svg';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faArrowRightToBracket } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom';



function Header() {


    
    return (

        <header className="Header">
        <img src={Logo} alt="Logo" />
        <div>
        <Link to="/signup">
        <button className="Header__button-1">
        <span>Crear Cuenta</span></button>
        </Link>
        <Link to='/signin'>
        <button className="Header__button" >
        <FontAwesomeIcon icon={faArrowRightToBracket} className="Header__button--icon" />
        <span>Iniciar Sesión</span></button>
        </Link>
        </div>
    
        </header>
    )
        
    }


export { Header };