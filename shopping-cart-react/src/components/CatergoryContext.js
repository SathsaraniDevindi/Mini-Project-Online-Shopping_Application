import React, { Component } from 'react'

export const DataContext = React.createContext();

export class DataProviderCatergory extends Component {

    state = {
        catergories: [
            {
                "catergory_id": "1",
                "title": "Bakery",
                "src": "https://images.unsplash.com/photo-1551782450-a2132b4ba21d",
                "description": "UI/UX designing, html css tutorials",
                "content": "Welcome to our channel Dev AT. Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.",
                "price": 17,
                "colors": ["orange", "black", "crimson", "teal"],
                "count": 1
                
            },
            {
                "catergory_id": "2",
                "title": "Beverages",
                "src": "https://images.unsplash.com/photo-1589948100953-963e39185fd6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1936&q=80",
                "description": "UI/UX designing, html css tutorials",
                "content": "Welcome to our channel Dev AT. Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.",
                "price": 17,
                "colors": ["orange", "black", "crimson", "teal"],
                "count": 1
            },
            {
                "catergory_id": "3",
                "title": "Dairy",
                "src": "https://media.istockphoto.com/photos/various-fresh-dairy-products-picture-id544807136",
                "description": "UI/UX designing, html css tutorials",
                "content": "Welcome to our channel Dev AT. Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.",
                "price": 17,
                "colors": ["orange", "black", "crimson", "teal"],
                "count": 1
            },
            {
                "catergory_id": "4",
                "title": "Vegetables",
                "src": "https://images.unsplash.com/photo-1567306301408-9b74779a11af",
                "description": "UI/UX designing, html css tutorials",
                "content": "Welcome to our channel Dev AT. Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.",
                "price": 17,
                "colors": ["orange", "black", "crimson", "teal"],
                "count": 1
            },
            {
                "catergory_id": "5",
                "title": "Fruits",
                "src": "https://images.unsplash.com/photo-1610832958506-aa56368176cf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                "description": "UI/UX designing, html css tutorials",
                "content": "Welcome to our channel Dev AT. Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.",
                "price": 17,
                "colors": ["orange", "black", "crimson", "teal"],
                "count": 1
            },
            {
                "catergory_id": "6",
                "title": "Pharmacy",
                "src": "https://images.unsplash.com/photo-1471864190281-a93a3070b6de?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                "description": "UI/UX designing, html css tutorials",
                "content": "Welcome to our channel Dev AT. Here you can learn web designing, UI/UX designing, html css tutorials, css animations and css effects, javascript and jquery tutorials and related so on.",
                "price": 17,
                "colors": ["orange", "black", "crimson", "teal"],
                "count": 1
            }
        ],
        cart: [],
        total: 0
        
    };

    addCart = (id) =>{
        const {catergories, cart} = this.state;
        const check = cart.every(item =>{
            return item.catergory_id !== id
        })
        if(check){
            const data = catergories.filter(catergory =>{
                return catergory.catergory_id === id
            })
            this.setState({cart: [...cart,...data]})
        }else{
            alert("The product has been added to cart.")
        }
    };

    reduction = id =>{
        const { cart } = this.state;
        cart.forEach(item =>{
            if(item.catergory_id === id){
                item.count === 1 ? item.count = 1 : item.count -=1;
            }
        })
        this.setState({cart: cart});
        this.getTotal();
    };

    increase = id =>{
        const { cart } = this.state;
        cart.forEach(item =>{
            if(item.catergory_id === id){
                item.count += 1;
            }
        })
        this.setState({cart: cart});
        this.getTotal();
    };

    removeProduct = id =>{
        if(window.confirm("Do you want to delete this product?")){
            const {cart} = this.state;
            cart.forEach((item, index) =>{
                if(item.catergory_id === id){
                    cart.splice(index, 1)
                }
            })
            this.setState({cart: cart});
            this.getTotal();
        }
       
    };

    getTotal = ()=>{
        const{cart} = this.state;
        const res = cart.reduce((prev, item) => {
            return prev + (item.price * item.count);
        },0)
        this.setState({total: res})
    };
    
    componentDidUpdate(){
        localStorage.setItem('dataCart', JSON.stringify(this.state.cart))
        localStorage.setItem('dataTotal', JSON.stringify(this.state.total))
    };

    componentDidMount(){
        const dataCart = JSON.parse(localStorage.getItem('dataCart'));
        if(dataCart !== null){
            this.setState({cart: dataCart});
        }
        const dataTotal = JSON.parse(localStorage.getItem('dataTotal'));
        if(dataTotal !== null){
            this.setState({total: dataTotal});
        }
    }
   

    render() {
        const {catergories, cart,total} = this.state;
        const {addCart,reduction,increase,removeProduct,getTotal} = this;
        return (
            <DataContext.Provider 
            value={{catergories, addCart, cart, reduction,increase,removeProduct,total,getTotal}}>
                {this.props.children}
            </DataContext.Provider>
        )
    }
}


