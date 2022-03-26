import { render } from '@testing-library/react';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import AllProducts from '../AllProducts';


it("renders without crashing", ()=>{
    const div = document.createElement("div");

    ReactDOM.render(
        <BrowserRouter>
        <AllProducts/>
        </BrowserRouter>, div)
     
})

