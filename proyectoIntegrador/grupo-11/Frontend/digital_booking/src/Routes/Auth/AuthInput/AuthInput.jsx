import React from "react";
import '../SignUp/SignUp.css';


const Input = (props) => {

    const [focused, setFocused] = React.useState(false);

    const { className, label, placeholder, 
            errorMessage, 
            id, onChange, 
            ...inputProps } = props;

    const handleFocus = (e) => {
        setFocused(true);
    }



    return (
        <>
           
            <div className="input-container">
                <span className="formulario__label">{label}</span>
                <input
                    // className={".input"}
                    placeholder={props.placeholder}
                    onChange={onChange}
                    {...inputProps}
                    onBlur={handleFocus}
                    focused={focused.toString()}
                    
                />  
                <p className="formulario__input-error" >
                    {errorMessage}
                </p>
            </div>
        </>
    )
}

export { Input };