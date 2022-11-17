import React from 'react';
import './BookingSearch.css';
// imports front awesome icons
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCalendarDays } from '@fortawesome/free-solid-svg-icons';
import { faLocationDot } from '@fortawesome/free-solid-svg-icons';

import { RiMapPin2Line } from 'react-icons/ri';
// imports paquete React-DateRange
import 'react-date-range/dist/styles.css'; // main css file
import 'react-date-range/dist/theme/default.css'; // theme css file
import { DateRange } from 'react-date-range';
import { format } from "date-fns";
import Data from '../Data/city.json';



function BookingSearch() {
    // manejo del estado para el calendario
    const [openDate, setOpenDate] = React.useState(false);

    // manejo del estado para mostrar y cerrar modal ciudades
    const [cityOpen, setCityOpen] = React.useState(false);

    // manejo del estado para la seleccion de ciudades
    const [city, setCity] = React.useState('');

    // custom hook para manejar el estado de la fecha
    const [date, setDate] = React.useState([
        {
            startDate: new Date(),
            endDate: new Date(),
            key: 'selection'
        }
    ]);


    return (

        <section className="booking-search">
            <h1 className="booking-search__title">Alquila tu proximo auto, inicia tu viaje</h1>
            <form className="booking-search__form">
                <div  className="booking-search__form__city">
                    {/* <FaMapMarkerAlt className="booking-icon" /> */}
                    <FontAwesomeIcon icon={faLocationDot} className="booking-icon" />
                    <span onClick={() => setCityOpen(!cityOpen)} // abre y cierra el modal de ciudades
                    className="booking-search__form--select--text">{city ? city : "Lugar de retiro"}</span>
                </div>
                { cityOpen && <div className="booking-search__form--select--city">
                <span className="booking-search__form--select--city--text">Seleccione una ciudad</span>
                {Data.map((city) => ( // recorre el json de ciudades y muestra las ciudades
                    <div className="booking-search__form--select--city--list">
                        <span onClick={() => setCity([city.ciudad]) || setCityOpen(!cityOpen)} // captura el valor de la ciudad seleccionada y cierra el modal
                        className="booking-search__form--select--city--list--text"><RiMapPin2Line/>{city.ciudad}</span>
                        <span className="booking-search__form--select--city--list--text--country">{city.pais}</span>
                    </div>
                ))} 

                </div>}
                <div className="booking-search__form--input">
                    <FontAwesomeIcon icon={faCalendarDays} className = "booking-icon__date" />
                    <span onClick={() => setOpenDate(!openDate)} // abre y cierra el calendario
                        className="booking-search__form--date">{`${"Retiro"} ${format(date[0].startDate, "dd/MM/yyyy")}
                        - ${"Entrega"} ${format(date[0].endDate, "dd/MM/yyyy")}`}</span>
                </div>
                {openDate && <DateRange 
                    editableDateInputs={false}
                    onChange={item => setDate([item.selection])}
                    moveRangeOnFirstSelection={false}
                    ranges={date}
                    className="booking-search__form--input--calendar"
                    rangeColors={["#FBC02D"]}

                />}

                {openDate && <span onClick={() => setOpenDate(!openDate)} // cierra el calendario al hacer click en el boton
                className="booking-search__button-calendar">Confirmar</span>}
                <button className="booking-search__button">Buscar</button>
            </form>
        </section>
    );
}

export { BookingSearch };
