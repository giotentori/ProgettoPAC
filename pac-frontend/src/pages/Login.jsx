import React from 'react'

import styled from "styled-components";
import Header from '../components/Header';

const PageContainer = styled.div `

`;

const Container = styled.div`
  width: 100vw;
  height: 100vh;
  background-size: cover;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: aliceblue;
`;

const Wrapper = styled.div`
  width: 40%;
  padding: 20px;
  background-color: white;
  border: 1px solid black;
`;

const Title = styled.h1`
  font-size: 24px;
  font-weight: 300;
`;

const Form = styled.form`
  display: flex;
  flex-direction: column;
`;

const Input = styled.input`
  flex: 1;
  min-width: 40%;
  margin: 10px 0;
  padding: 10px;
`;

const Button = styled.button`
  width: 40%;
  border: none;
  padding: 15px 20px;
  background-color: #d33830;
  color: white;
  cursor: pointer;
  margin-bottom: 10px;
  margin: 0 auto;
`;

const Link = styled.a`
  margin: 5px 0px;
  font-size: 12px;
  text-decoration: underline;
  cursor: pointer;
`;


const Login = () => {
  return (
  <PageContainer>
    <Header/>
    <Container>
      <Wrapper>
          <Title>ACCEDI AL TUO ACCOUNT</Title>
          <Form>
            <Input placeholder='Email' />
            <Input placeholder='Password' />
            <Button>LOGIN</Button>
            <Link>NON RICORDI LA PASSWORD?</Link>
            <Link>CREA UN NUOVO ACCOUNT</Link>
          </Form>
      </Wrapper>
  </Container>
</PageContainer>
  )
}

export default Login