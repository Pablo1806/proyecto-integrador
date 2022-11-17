import React from "react";
import LogoSignin from "../assets/Logo/logo_signin.svg";
import { Footer } from "../../../Components/Footer/Footer";
import { Input } from "../AuthInput/AuthInput";
import { Link } from 'react-router-dom';
import "./SignUp.css";



const SignUp = () => {


    const [values, setValues] = React.useState({
        name: "",
        lastName: "",
        email: "",
        password: "",
        confirmPassword: "",
    });

    const inputs = [
        {
            id: 1,
            label: "Nombre",
            type: "text",
            required: true,
           
            
        },
        {
            id: 2,
            label: "Apellido",
            type: "text",
            required: true,
          
            

        },
        {
            id: 3,
            label: "Correo electronico",
            type: "email",
            name: "email",
            errorMessage: "Formato de correo incorrecto ingresa un correo valido!",
            required: true,
            pattern: "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",

        },
        {
            id: 4,
            label: "Contraseña",
            type: "password",
            name: "password",
            errorMessage: "La contraseña debe tener entre 8 y 20 caracteres e incluir al menos 1 letra, 1 número y 1 carácter especial",
            required: true,
            pattern: `(?=[A-Za-z0-9@#$%^&+!=]+$)^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+!=])(?=.{8,}).*$`,

        },
        {
            id: 5,
            label: "Confirmar contraseña",
            type: "password",
            name: "confirmPassword",
            errorMessage: "Las contraseñas no coinciden",
            required: true,
            pattern: values.password,
        }
    ]


    const handleSubmit = (e) => {
        e.preventDefault();
    }


    const onChange = (e) => {
        setValues({
            ...values,
            [e.target.name]: e.target.value,
        });
    };


    return (
        <>
            <header className="Header-signin">
                <img src={LogoSignin} alt="Logo" />
                <div>
                <Link to="/signin">
                    <button className="Header__button-signin">Iniciar sesion</button>
                </Link>
                </div>
            </header>

            <div className="container-signup">
                <form onSubmit={handleSubmit} className="container__form-signup" id="login" >

                    <label className="container__title-signup">Crear Cuenta</label>

                
                        {inputs.map((input) => (
                            <Input
                                key={input.id}
                                {...input}
                                value={values[input.name]}
                                onChange={onChange}
                                
                            />

                        ))}
             
                    <button type="submit" className="button-signup" id="btn">
                        Ingresar
                    </button>
                    <Link to="/signin" className="link">
                    <p className="container__form-register">
                        ¿Ya tienes una cuenta? <a>Inicia sesion</a>
                    </p>
                    </Link>
                </form>
            </div>
            <Footer />
        </>
    );
};

export { SignUp };