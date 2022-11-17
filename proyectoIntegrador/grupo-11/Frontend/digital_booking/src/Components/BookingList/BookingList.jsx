import React from "react";
import './BookingList.css';
import Data from "../Data/data.json";
// imports Font Awesome icons
import { RiMapPin2Line } from 'react-icons/ri';
import { AiTwotoneHeart } from 'react-icons/ai';


function BookingList() {

   

          


    return (
        <section className="booking-category__list" >
            <h3 className="booking-category__list--title">Nuestros Autos</h3>
            <div className="booking-category__list--container" >
                
                { Data.map((category) => ( // recorre el json y muestra las cards con los datos
                    <div className="booking-category__list--container--card" key={category.id} >
                        <img className="booking-category__list--container--card--img" src={category.producto.img} alt = {category.producto.img} />
                        <div className="booking-category__list--container--card--info">
                            <AiTwotoneHeart className="booking-category__list--container--card--heart" />
                            <span className="booking-category__list--container--card--title">{category.producto.title}</span>
                            <span className="booking-category__list--container--card--location"><RiMapPin2Line />{category.producto.location}</span>
                            <span className="booking-category__list--container--card--category">{category.producto.category}</span>
                            <p className="booking-category__list--container--card--description">{category.producto.description}</p>
                            <button className="booking-category__list--container--card--button">Reservar</button>
                        </div>
                    </div>
                ))}
               
            </div>
        </section>
    )

}

export { BookingList };