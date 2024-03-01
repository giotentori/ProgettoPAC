import React, { useState } from 'react'
import styled from 'styled-components'
import Header from '../components/Header';


const PageContainer = styled.div `
    
`;

const Container = styled.div `
    width: 100vw;
    height: 100vh;
    background-size: cover;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: aliceblue;
`;

const Wrapper = styled.div `
    width: 40%;
    padding: 20px;
    background-color: white;
    border: 1px solid black;
`;

const Title = styled.h1 `
    font-size: 24px;
    font-weight: 300;
`;

const Form = styled.form `
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
`;

const Input = styled.input `
    flex: 1;
    min-width: 40%;
    margin: 20px 10px 0px 0px;
    padding: 10px;
`;

const Agreement = styled.span `
    font-size: 12px;
    margin: 20px 0px;
`;

const Button = styled.button `
    width: 40%;
    border: none;
    padding: 15px 20px;
    background-color: #d33830;
    color: white;
    cursor: pointer;
    margin: 0 auto;
`;




const Register = () => {

    const [firstName,setFirstName] = useState('');
    const [lastName,setLastName] = useState('');
    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');

    const handleRegistration=(e)=>{
        e.preventDefault()
        const user={firstName,lastName,email,password}
        fetch("http://localhost:8080/registration/user",{
          method:"POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(user)
        //TODO: Cercare di ricevere la risposta restituita
      })
      setFirstName("");
      setLastName("");
      setEmail("");
      setPassword("");
    }
    

  return (
    <PageContainer>
        <Header/>
        <Container>
            <Wrapper>
                <Title>CREA UN ACCOUNT</Title>
                <Form>
                    <Input placeholder="Nome" value={firstName} onChange={(e) => setFirstName(e.target.value)} />
                    <Input placeholder="Cognome" value={lastName} onChange={(e) => setLastName(e.target.value)} />
                    <Input placeholder="Email" value={email} type="email" onChange={(e) => setEmail(e.target.value)} />
                    <Input placeholder="Password" value={password} type="password" onChange={(e) => setPassword(e.target.value)} />
                    <Agreement>
                        Con la creazione dell'account, acconsento al trattamento dei miei dati 
                        personali in accordo con <b>PRIVACY POLICY</b>
                    </Agreement>
                    <Button onClick={handleRegistration}>CREATE</Button>
                </Form>
            </Wrapper>
        </Container>
    </PageContainer>
  )
}

export default Register