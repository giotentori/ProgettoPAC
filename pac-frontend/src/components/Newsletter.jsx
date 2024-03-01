import styled from 'styled-components'
import Send from '@mui/icons-material/Send';


const Container = styled.div `
    height: 60vh;
    background-color: #b0cbe3;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

const Title = styled.h1 `
    font-size: 70px;
    margin-bottom: 20px;
`;

const Desc = styled.div`
    font-size: 24px;
    font-weight: 300;
    margin-bottom: 20px;
`;

const InputContainer = styled.div `
    width: 50%;
    height: 40px;
    background-color: white;
    display: flex;
    justify-content: space-between;

    border: 1px solid lightgray;
`;

const Input = styled.input `
    flex: 10;
    border: none;
    padding-left: 10px;
`;

const Button = styled.button `
    flex: 1;
    border: none;
    background-color: teal;
    color: white;
`;



const Newsletter = () => {
  return (
    <Container>
        <Title> Newsletter</Title>
        <Desc>Signup and get news!</Desc>
        <InputContainer>
            <Input placeholder='Email'/>
            <Button>
                <Send />
            </Button>
        </InputContainer>
    </Container>
  )
}

export default Newsletter