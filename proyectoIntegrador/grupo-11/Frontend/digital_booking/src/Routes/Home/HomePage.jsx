import React from 'react';
import './HomePage.css';
import { Header } from '../../Components/Header/Header';
import { Footer } from '../../Components/Footer/Footer';
import { BookingSearch } from '../../Components/BookingSearch/BookingSearch';
import { BookingCategory } from '../../Components/BookingCategory/BookingCategory';
import { BookingList } from '../../Components/BookingList/BookingList';
// import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';


function HomePage() {

  // const {
  //   openDate, setOpenDate, date, setDate,
  // } = React.useState(false);


  return (
    <React.Fragment>
      <Header 
      
      />

      <BookingSearch 
        // openDate={openDate}
        // setOpenDate={setOpenDate}
        // date={date}
        // setDate={setDate}
      
      />

      <BookingCategory />

      <BookingList />

      
      


      <Footer />
    </React.Fragment>

  );
}


export { HomePage };