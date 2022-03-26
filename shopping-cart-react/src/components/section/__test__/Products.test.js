import {mount,shallow} from 'enzyme';
import Products from '../Products';
import React from 'react';
import { configure } from "enzyme";
import Adapter from "enzyme-adapter-react-16";
configure({ adapter: new Adapter() });
it("renders without crashing", ()=>{
    
mount(<Products/>);
})


  