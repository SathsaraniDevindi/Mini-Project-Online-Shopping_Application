import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import '../css/Products.css'
import axios from 'axios'
    

export class Products extends Component {

    constructor(props){
        super(props);
        this.state={
            products : []
            
        }
    }

    componentDidMount(){
        const val = this.props.location.state.id;
        const cat = this.props.location.state.catName;
        console.log(val);
        console.log(cat);
        const new_path = `http://localhost:8080/category/${val}`;
        console.log(new_path);
        axios.get(new_path)
             // .then(response=>console.log(response.data))
              .then(response=>response.data)
              .then((data)=>{
                  this.setState({products: data});
              });
    }

 

    render() {
          
        return (
            
            <div id="product">
                <div className='center'>
                       <h1>{this.props.location.state.catName}</h1>
                   </div>
               {
               
                   this.state.products.map(product =>(
                       
                       <div className="card" key={product.id}>
                           <Link to={`/product/${product.id}`}>
                               <img src={product.product_img} alt=""/>
                           </Link>
                           <div className="content">
                               <h3>
                               {/* {product.product_name} */}
                                   <Link to={{pathname:`/product/Id/${product.id}`,state:{id:product.id,name:product.product_name,price:product.price,amount:product.amount,manu:product.manufacturer,img:product.product_img}}}>{product.product_name}</Link>
                               </h3>
                               <span>Rs.{product.price}</span>
                              
                               {/* <button onClick={()=> addCart(product.catergory_id)}>Add to cart</button> */}
                           </div>
                       </div>
                   ))
                   
               }
            </div>
        )
    }
}

export default Products
