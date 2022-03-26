import React, { Component } from 'react'
import Products from './section/Products'
import {Route} from "react-router-dom"
import Cart from './section/Cart'
import Catergories from './section/Catergories'
import AllProducts from './section/AllProducts'
import SearchResults from './section/SearchResults'
import Details from './section/Details'



export class Section extends Component {
    render() {
        return (
            <section>
                    <Route path="/" component={Catergories} exact />
                    <Route path="/category" component={Catergories} exact />
                    <Route path="/products" component={AllProducts} exact  />
                    <Route path="/product/Id/:id" component={Details} exact  />
                    <Route path="/searchresults" component={SearchResults} exact  />                  
                    <Route path="/category/:catergory_id" component={Products} exact />
                    <Route path="/cart" component={Cart}  exact/>
            </section>
        )
    }
}

export default Section
