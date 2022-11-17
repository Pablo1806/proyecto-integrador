import React from "react";
import './BookingCategory.css';
import Data from "../Data/data.json";


function BookingCategory() {
    return (
        <section className="booking-category">
            <h2 className="booking-category__title">Nuestras Categorias</h2>
        <div className="booking-category__container">
            {Data.filter((category) => category.id === "1" || category.id === "3" 
            || category.id === "5" || category.id === "8").map((category) => ( // filtra las categorias y muestra 4 categorias del json
                <div className="booking-category__container--card">
                    <img className="booking-category__container--card--img" src={category.producto.img} alt={category.name} />
                    <h3 className="booking-category__container--card--title">{category.producto.category}</h3>

                </div>
            ))}
        </div>
        </section>
    )

}

    export { BookingCategory }; 