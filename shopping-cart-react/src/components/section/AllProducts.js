import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import '../css/Products.css'
import axios from 'axios'
    

export class AllProducts extends Component {

    constructor(props){
        super(props);
        this.state={
            products : []
            
        }
    }

    componentDidMount(){
        
        axios.get("http://localhost:8080/products")
             // .then(response=>console.log(response.data))
              .then(response=>response.data)
              .then((data)=>{
                  this.setState({products: data});
              });
    }

 

    render() {
         
        return (
            
            <div id="product">
                <h1>Products</h1>
               {
  
                   this.state.products.map(product =>(
                       
                       <div className="card" key={product.id}>
                           <Link to={`/product/${product.id}`}>
                               <img src={product.product_img} alt=""/>
                           </Link>
                           <div className="content">
                               <h3>
                                   <Link to={`/product/${product.id}`}>{product.product_name}</Link>
                               </h3>
                               <div>
                               <span>Rs.{product.price}</span>
                                   {/* <button >Add to cart</button> */}
                                   {/* <button onClick={()=> addCart(product.id)}>Add to cart</button> */}
                               </div>
                               
                              
                               
                           </div>
                       </div>
                   ))
                   
               }
            </div>
        )
    }
}

export default AllProducts
