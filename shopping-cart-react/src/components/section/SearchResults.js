import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import '../css/Products.css'

export class SearchResults extends Component {

    render() {     
              
        return (
            
            <div id="product">
                <h1>Search Results...</h1>
               {                 
                  this.props.history.location.state.filteredProducts.map(product =>(
                       
                       <div className="card" key={product.product_id}>
                          
                               <img src={product.product_img} alt=""/>
                        
                           <div className="content">
                               <h3>
                               {product.product_name}                                  
                               </h3>
                               <span>Rs.{product.price}</span>                                                            
                           </div>
                       </div>
                   ))
                   
               }
            </div>
        )
    }
}

export default SearchResults 
