import React from 'react'
import Header from '../components/Header';
import Categories from '../components/Categories';
import Intro from '../components/Intro';
import Footer from '../components/Footer';
import Newsletter from '../components/Newsletter';

const Home = () => {
  return (
    <div>
        <Header/>
        <Intro/>
        <Categories/>
        <Newsletter/>
        <Footer/>
    </div>
  )
}

export default Home