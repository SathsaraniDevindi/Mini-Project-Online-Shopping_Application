import React, { Component } from 'react'
import '../css/Products.css'
import axios from 'axios'

    

export class SearchBarSection extends Component {
    constructor(props){
        super(props);
        this.state={
            products : [],
            search :"",
            filteredProducts : []
            
        }
        this.filteredProducts = this.filteredProducts.bind(this);
        this.products = this.products.bind(this);
    }
    
    componentDidMount(){
        axios.get("http://localhost:8080/products")
        // .then(response=>console.log(response.data))
        .then(response=>response.data)
        .then((data)=>{
            this.setState({products: data});
        });
    }

    filteredProducts = this.products.filter((product) => {
        if (
          product.product_name.toLowerCase().includes(this.search)
          
        ) {
          return product;
        }
      });


  render(){
    return (
      <div className="searchBarSection">
        <div class="searchBar">
          <input
            className="input"
            onChange={(e) => {
              this.setState({search:e.target.value.toLowerCase()})
            }}
          />
          <button className="button">
            <svg
              className="w-6 h-6"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              ></path>
            </svg>
          </button>
        </div>
        <div className="display">
          {this.filteredProducts.map((product) => (
            <div className="product">
              <h6>{product.product_name}</h6>
              
              <h5>{product.price}</h5>
            </div>
          ))}
        </div>
      </div>
    );
 }
  };
  
  export default SearchBarSection;