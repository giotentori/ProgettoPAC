import React from 'react'
import { Link } from 'react-router-dom';
import styled from "styled-components";
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import Logo2 from '../images/logo2.jpeg'

const Container = styled.div`
    background-color: rgb(10, 102, 194);
    max-height: 150px;
    margin: auto;
    padding-left: 25px;
    padding-right: 25px;
`;

const Navbar = styled.div`
    display: flex;
    align-items: center;
    padding: 20px;
`;

const Logo = styled.div`

`;

const Nav = styled.nav`
    flex: 1;
    text-align: right;
`;

const Header = () => {
  return (
    <Container>
        <Navbar>
            <Logo>
                <img src={Logo2} alt='logo' width="120px"/>
            </Logo>
            <Nav>
                <ul>
                    <li><Link to="/" style={{color: '#ffffff', textDecoration: "none"}}>Home</Link></li>
                    <li><Link to="/products" style={{color: '#ffffff', textDecoration: "none"}}>Products</Link></li>
                    <li><Link to="/" style={{color: '#ffffff', textDecoration: "none"}}>About us</Link></li>
                    <li><Link to="/" style={{color: "#ffffff", textDecoration: "none"}}>Contacts</Link></li>
                    <li><Link to="/register" style={{color: "#ffffff", textDecoration: "none"}}>Register</Link></li>
                </ul>
            </Nav>
            <Link to="/login" style={{color: "#000000", textDecoration: "none"}}><AccountCircleIcon/></Link>
        </Navbar>
    </Container>
  )
}

export default Header