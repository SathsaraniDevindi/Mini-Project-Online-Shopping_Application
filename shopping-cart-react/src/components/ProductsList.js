import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import '../css/Products.css'
import axios from 'axios'
    
function ProductsList(){
    axios.get("http://localhost:8080/products")
    // .then(response=>console.log(response.data))
     .then(response=>response.data)
     .then((data)=>{
         this.setState({products: data});
     });
     return  this.products
     
}
