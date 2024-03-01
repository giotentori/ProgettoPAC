import React from 'react'
import styled from 'styled-components'

const Container = styled.div `
    flex: 1;
    margin: 3px;
    height: 80vh;
    position: relative;
`;

const Image = styled.img `
    width: 100%;                        //Le immagini occupano il 100% della larghezza del contenitore padre, non strabordano
    height: 100%;   
    object-fit: cover;                  // Sistema la visualizzazione delle immagini
`;

const Info = styled.div `
    position: absolute;                 //Absolute position rispetto al padre
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;                //Imposto centrati verticalmente(orizzontalmente perchè ho cambiato direction)
    justify-content: center;
    
`;

const Title = styled.h1 `
    color: white;
    margin-bottom: 20px;                //Metto spazio tra titolo e bottone
`;

const Button = styled.button `
    border:none;
    padding: 10px;
    background-color: white;
    color: gray;
    cursor: pointer;
    border-radius: 30px;
    font-weight: 600;
`;



const CategoryItem = ({item}) => {
  return (
    <Container>
        <Image src={item.img}/>
        <Info>
            <Title>{item.title}</Title>
            <Button>SEARCH NOW</Button>
        </Info>
    </Container>
  )
}

export default CategoryItem