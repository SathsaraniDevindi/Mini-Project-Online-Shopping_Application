import React, { Component } from 'react'
import '../css/Details.css'
import axios from 'axios'
    


export class Details extends Component {
   
    constructor(props){
        console.log(props)
        super(props);
        this.state={
            products : []
            
        }
    }

    componentDidMount(){
        const val = this.props.location.state.id;    
        console.log(val);
        const new_path = `http://localhost:8080/product/Id/${val}`;
        console.log(new_path);
        axios.get(new_path)
             // .then(response=>console.log(response.data))
              .then(response=>response.data)
              .then((data)=>{
                  this.setState({products: data});
              });
    }
   


    render() {
        console.log(this.props.location.state.name)
        return (
           <div className='card'>
                <img src={this.props.location.state.img} alt=""/>
            <div className="content">
                <h3>
                  {this.props.location.state.name}</h3>
                  <div>
                      <h3>
                  <span>Rs.{this.props.location.state.price}</span></h3>
                  </div>
                  <div>
                      <h4>Manufacturer : {this.props.location.state.manu}</h4>
                  
                  </div>
                  
                   </div>
           </div>
                
            
        )
    }
}

export default Details
