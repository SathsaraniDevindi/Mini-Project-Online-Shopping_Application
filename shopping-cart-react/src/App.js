import React from 'react';
import {BrowserRouter as Router} from 'react-router-dom'
import Header from './components/Header'
import Section from './components/Section'
import {DataProviderCatergory} from './components/CatergoryContext'


class App extends React.Component{
  render(){
    return(
      // <DataProviderCatergory>
        <div className="app">
          <Router>
            <Header />
            <Section />
          </Router>
        </div>
      // </DataProviderCatergory>
    );
  }
}

export default App;
