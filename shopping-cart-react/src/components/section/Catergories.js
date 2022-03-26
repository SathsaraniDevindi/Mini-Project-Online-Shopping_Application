import React, { Component } from 'react'
import {Link} from 'react-router-dom'
//import {DataContext} from '../CatergoryContext'
import '../css/Products.css'
import axios from 'axios'


export class Catergories extends Component {
    constructor(props){
        super(props);
        this.state={
            catergories : []
        }
    }

    componentDidMount(){
        axios.get("http://localhost:8080/category")
             // .then(response=>console.log(response.data))
              .then(response=>response.data)
              .then((data)=>{
                  this.setState({catergories: data});
              });
    }

  
   // static contextType = DataContext;

    render() {
       // const {catergories} = this.context;
       const filterResult=(category_itm)=>{
           const sendData = category_itm;
        //    const result=this.state.catergories.filter((curData)=>{
        //        return curData.category_id===category_itm;
        //    });
        //    this.setState(result)
        //    console.log(result)

       }
       
        return (
            <div id="product">
               {
                   this.state.catergories.map(product =>(
                       <div className="card" key={product.category_id}>
                           <Link to={{pathname:`/category/${product.category_id}`,state:{id:product.category_id,catName:product.category_name}}}onClick={()=>filterResult(product.category_id)
                                }>
                               <img src={product.img_src} alt=""/>
                           </Link>
                           <div className="content">
                               <h3>
                                   {/* <Link to={`/category/${product.category_id}`}onClick={()=>filterResult(product.category_id) */}
                                   <Link to={{pathname:`/category/${product.category_id}`,state:{id:product.category_id,catName:product.category_name}}}onClick={()=>filterResult(product.category_id)
                                }>{product.category_name}</Link>
                               </h3>                           
                           </div>
                       </div>
                   ))
               }
            </div>
        )
    }
}

export default Catergories
