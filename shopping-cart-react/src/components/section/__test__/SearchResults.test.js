import { render } from '@testing-library/react';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import SearchResults from '../SearchResults';

it("renders without crashing", ()=>{
    const div = document.createElement("div");

    ReactDOM.render(   
        <SearchResults/>, div)
     
})

