import React from 'react'
import styled from 'styled-components'
import { Link } from 'react-router-dom';
import HomeImage from '../images/homeImage.png'

const Container = styled.div`
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  justify-content: space-around;
  background-color: aliceblue;
`;

const Introduction = styled.div`
  margin-top: 60px;
`;

const H1 = styled.h1`
  font-size: 50px;
  line-height: 60px;
  margin: 20px 0;
`;

const ImgContainer = styled.div`
  flex-basis: 50%;                //Imposto a metà del padre lo spazio massimo occupabile da ImgContainer
  min-width: 300px;
  margin-top: 60px;
`;

const Image = styled.img`
  max-width: 100%;
  padding: 20px 0;
  margin-bottom: 40px;
`;

const Button = styled.button`
  display: inline-block;
  background-color: rgb(10, 102, 194);
  border: none;
  cursor: pointer;
  transition: background-color 0.5s;
  padding: 8px 30px;
  margin: 30px 0;
  height: 40px;
  border-radius: 30px;
  &:hover{
    background-color: rgb(2, 70, 138);
  }
`;

const Intro = () => {
  return (
    <Container> 
        <Introduction>
            <H1>Trova il portatile per te!</H1>
                <p>Innovation distinguishes between a leader and a follower.<br/>-Steve Jobs</p>
                <Button><Link to="/products" style={{color: "#fff",fontWeight: "bold" ,textDecoration: "none" ,fontSize: "17px"}}>Iniziamo!</Link></Button>
            </Introduction>
            <ImgContainer>
              <Image src={HomeImage} alt="image" />
            </ImgContainer>
    </Container>
  )
}

export default Intro