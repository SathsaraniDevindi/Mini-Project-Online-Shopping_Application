import React, { Component } from 'react'
import Menu from './svg/bars-solid.svg'
import CartIcon from './svg/shopping-cart-solid.svg'
import {Link} from 'react-router-dom'
import './css/Header.css'
import {DataContext} from './CatergoryContext'
import { Redirect } from 'react-router-dom'
import axios from 'axios'


export class Header extends Component {
    static contextType = DataContext;

    state = {
        toggle: false,
        search: "",
        List: []
    }


    onchange = e => {        
        this.setState({ search: e.target.value });
      };

      componentDidMount() {
        axios.get("http://localhost:8080/products")
             // .then(response=>console.log(response.data))
              .then(response=>response.data)
              .then((data)=>{
                  this.setState({List: data});
              });
    }

    render() {
        const {toggle} = this.state;
      //  const {cart} = this.context;
        const { search } = this.state;
        // console.log("dddddddddd")
        // console.log(this.state.List)
        const filteredProducts = this.state.List.filter(product => {
          return product.product_name.toLowerCase().indexOf(search.toLowerCase()) !== -1;
        });
        return (
            <header>
                <div className="menu">
                    <img src={Menu} alt="" width="20"/>
                </div>
                <div className="logo">
                    <h1><Link to="/">Food Villa</Link></h1>
                </div>
                <div className='searchbar'>
              
                <input
                  label="Search Product"
                  icon="search"
                  placeholder='Search Product..'
                   onChange={this.onchange}
                />
                    </div>
                    <div className="row">
              {filteredProducts.map(product => {
                  console.log(product)
                  console.log(filteredProducts.length)
               
              })}

            {filteredProducts.length > 0 &&            
                    <Redirect to={{
                        pathname: '/searchresults',
                        state: { filteredProducts: filteredProducts }
                        
                    }}
                    />
                    }         
            </div>

                <nav>
                    <ul className={toggle ? "toggle" : ""}>
                        <li><Link to="/">Home</Link></li>  
                        <li><Link to="/products">Products</Link></li>
                        <li><Link to="/contact">Contact</Link></li>
                        <li><Link to="/login">Login / Register</Link></li>
                    </ul>
                    <div className="nav-cart">
                        {/* <span>{cart.length}</span> */}
                        <Link to="/cart">
                            <img src={CartIcon} alt="" width="20"/>
                        </Link>
                    </div>
                </nav>
            </header>
        )
    }
}

export default Header
