import { render } from '@testing-library/react';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import Section from '../Section';


it("renders without crashing", ()=>{
    const div = document.createElement("div");

    ReactDOM.render(
        <BrowserRouter>
        <Section/>
        </BrowserRouter>, div)
     
})

