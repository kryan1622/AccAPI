import React from 'react';
import {
  Navbar,
  NavbarBrand,
  Nav,
  NavItem
} from 'reactstrap';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import { NavLink as RRNavLink } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUsers } from '@fortawesome/free-solid-svg-icons';


// import Login from './login.js';
import ItemPage from './get/path.js';
 import Create from './create.js';

export default class Example extends React.Component {

  render() {
    return (
      <div>
        <Router>
          <Navbar color="dark" dark expand="md">
            <NavbarBrand tag={RRNavLink} to="/">Account Creater</NavbarBrand>
            <Nav className="ml-auto" navbar>
              <NavItem>
                  <FontAwesomeIcon icon={faUsers} />
                <Link style={{ color: '#87898C' }} tag={RRNavLink}  to="/">Create Account</Link>
              </NavItem>
<NavItem>
                  <FontAwesomeIcon icon={faUsers} />
                <Link style={{ color: '#87898C' }} tag={RRNavLink}  to="/get">Get Accounts</Link>
              </NavItem>

            </Nav>
          </Navbar>

           <Route exact path="/" component={Create} />
          <Route exact path="/get" component={ItemPage} />


        </Router>

      </div>
    );
  }
}