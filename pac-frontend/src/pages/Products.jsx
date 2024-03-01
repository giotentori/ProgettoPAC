import React, { useEffect, useState } from 'react'
import styled from 'styled-components';
import Header from '../components/Header';
import Notebooks from '../components/Notebooks';
import NewsBoard from '../components/NewsBoard';

const Container = styled.div `
  
`
const Wrapper = styled.div `
  margin: 10px;
  margin-top: 15px;
  display: flex;
`
const FormContainer = styled.div `
  justify-content: center;
  flex: 1;
  border-right: solid 1px black;
`

const ProductFormBox = styled.div `
  padding: 25px;
  margin-top: 30px;
  margin-bottom: 30px;
  display: flex;
  flex-direction: column;
  border-bottom: solid 1px black ;
  justify-content: space-between;
`;

const NotebooksContainer = styled.div `
  flex: 3;
`

const Paragraph = styled.p `
  margin-left: 10px;
  margin-top: 20px;
  margin-bottom: 20px;
`;




const Products = () => {

  // Imposto una lista nuova di notebook e l'url per tutti i notebook
  const [notebooks,setNotebooks] = useState([]); 
  const urlGetAll = "http://localhost:8080/notebook/getAll";


  //Imposto i parametri per la ricerca
  const [brand,setBrand] = useState("");
  const [OS,setOS] = useState("");
  const [screenSize,setScreenSize] = useState("");
  const [ram,setRam] = useState("");
  const [storage,setStorage] = useState("");
  const [tod,setTod] = useState("");          //Type of disk
  const [CPU,setCPU] = useState("");
  const [GPU,setGPU] = useState("");
  const [minPrice,setMinPrice] = useState("");
  const [maxPrice,setMaxPrice] = useState("");


  //Restituisci tutti i notebook in catalogo
  const getAllNotebooks = () => {
    fetch(urlGetAll)
    .then(res => res.json())
    .then( (result) => {
        setNotebooks(result);
      })
    }

    const callNotebooks = (apiUrl) => {
      fetch(apiUrl)
      .then(res => res.json())
      .then( (result) => {
          setNotebooks(result);
        })
      }

  //Ricerca Notebook con parametri
  const getNotebooks = () => {
    //Implementare la logica per la chiamata delle API
    //Per ora il codice supporta la ricerca per campi singoli e per OS,ram,storage insieme.
    if( OS === "" && screenSize === "" && brand === "" && ram === "" && storage === "" && tod === "" && CPU === "" 
      && GPU === "" && minPrice === "" && maxPrice === ""){
        alert("Fill in missing parameters");
      } else if(OS !== "" & ram !=="" & storage !== ""){
        callNotebooks("http://localhost:8080/notebook/byOS&ram&storage?OS="+OS+"&ram="+ram+"&storage="+storage);
      } else if(brand !== "") {
        callNotebooks("http://localhost:8080/notebook/byBrand?brand="+brand);
      } else if(OS !== "") {
        callNotebooks("http://localhost:8080/notebook/byOS?OS="+OS);
      } else if(screenSize !== "") {
        callNotebooks("http://localhost:8080/notebook/byScreen?screen="+screenSize);
      } else if(ram !== "") {
        callNotebooks("http://localhost:8080/notebook/byRam?ram="+ram);
      } else if(storage !== "") {
        callNotebooks("http://localhost:8080/notebook/byStorage?storage="+storage);
      } else if(tod !== "") {
        callNotebooks("http://localhost:8080/notebook/byDisk?disk="+tod);
      } else if(GPU !== "") {
        callNotebooks("http://localhost:8080/notebook/byGpu?gpu="+GPU);
      } else if(minPrice !== "" && maxPrice !== "") {
        callNotebooks("http://localhost:8080/notebook/byPriceBetween?p1="+minPrice+"&p2="+maxPrice);
      } else if(minPrice !== "") {
        callNotebooks("http://localhost:8080/notebook/byMinPrice?price="+minPrice);
      }  else if(maxPrice !== "") {
        callNotebooks("http://localhost:8080/notebook/byMaxPrice?price="+maxPrice);
      } 
                                    
  }

  //Al caricamento della pagina, carico tutti i notebook (getAll)
  useEffect(() => {
    getAllNotebooks();
    console.log(notebooks);
    // eslint-disable-next-line
  },[])

  return (
  <Container>
    <head>
      <link rel="stylesheet" href="./products-page-css/products-page.css"/>
    </head>
    <Header/>
    <NewsBoard/>
    <Wrapper>
      <FormContainer>
        <form id='form-products'>
        <ProductFormBox>
        <p className='product-form-title'>Brand</p>
        <select className='product-form-select' name="brand" value={brand} onChange={(e => setBrand(e.target.value))}>
            <option className='product-form-option' value="" selected >_</option>
            <option className='product-form-option' value="APPLE">Apple</option>
            <option className='product-form-option' value="LENOVO">Lenovo</option>
            <option className='product-form-option' value="ASUS">Asus</option>
            <option className='product-form-option' value="ACER">Acer</option>
            <option className='product-form-option' value="HUAWEI">Huawei</option>
            <option className='product-form-option' value="HP">HP</option>
            <option className='product-form-option' value="MSI">MSI</option>
          </select>
        </ProductFormBox>
        <ProductFormBox>
        <p className='product-form-title'>Operating System</p>
          <select className='product-form-select' name="OS" value={OS} onChange={(e => setOS(e.target.value))}>
            <option className='product-form-option' value="" selected>_</option>
            <option className='product-form-option' value="WINDOWS">Windows</option>
            <option className='product-form-option' value="MACOS">MacOs</option>
            <option className='product-form-option' value="LINUX">Linux</option>
          </select>
        </ProductFormBox>
        <ProductFormBox>
        <p className='product-form-title'>Screen Size</p>
          <select className='product-form-select' name="screenSize" value={screenSize} onChange={(e => setScreenSize(e.target.value))}>
            <option className='product-form-option' value="" selected>_</option>
            <option className='product-form-option' value="13">13 inches</option>
            <option className='product-form-option' value="15">15 inches</option>
            <option className='product-form-option' value="17">17 inches</option>
          </select>
        </ProductFormBox>
        <ProductFormBox>
        <p className='product-form-title'>RAM</p>
          <select className='product-form-select' name="ram" value={ram} onChange={(e => setRam(e.target.value))}>
            <option className='product-form-option' value="" selected>_</option>
            <option className='product-form-option' value="8">8 GB</option>
            <option className='product-form-option' value="16">16 GB</option>
            <option className='product-form-option' value="32">32 GB</option>
          </select>
        </ProductFormBox>
        <ProductFormBox>
        <p className='product-form-title'>Storage</p>
          <select className='product-form-select' name="storage" value={storage} onChange={(e => setStorage(e.target.value))}>
            <option className='product-form-option' value="" selected>_</option>
            <option className='product-form-option' value="256">256 GB</option>
            <option className='product-form-option' value="512">512 GB</option>
            <option className='product-form-option' value="1000">1 TB</option>
            <option className='product-form-option' value="2000">2 TB</option>
          </select>
        </ProductFormBox>
        <ProductFormBox>
        <p className='product-form-title'>Type of Disk</p>
          <select className='product-form-select' name="tod" value={tod} onChange={(e => setTod(e.target.value))}>
            <option className='product-form-option' value="" selected>-</option>
            <option className='product-form-option' value="HDD">HDD</option>
            <option className='product-form-option' value="SSD">SSD</option>
          </select>
        </ProductFormBox>
        <ProductFormBox>
        <p className='product-form-title'>CPU</p>
            <input className='product-form-input' placeholder='Insert CPU' type='text' onChange={(e) => setCPU(e.target.value)} />
        </ProductFormBox>
        <ProductFormBox>
        <p className='product-form-title'>GPU</p>
          <select className='product-form-select' name="GPU" value={GPU} onChange={(e => setGPU(e.target.value))}>
            <option className='product-form-option' value="" selected>-</option>
            <option className='product-form-option' value="INTEL">Intel</option>
            <option className='product-form-option' value="AMD">AMD</option>
            <option className='product-form-option' value="APPLE">Apple</option>
            <option className='product-form-option' value="NVIDIA">NVIDIA</option>
          </select>
        </ProductFormBox>
        <ProductFormBox style={{border:"none"}}>
        <p className='product-form-title'>Price</p>
            <input className='product-form-input' id='product-form-price-min' placeholder='Min' type="number" onChange={(e) => setMinPrice(e.target.value)} />
            <input className='product-form-input' placeholder='Max' type="number" onChange={(e) => setMaxPrice(e.target.value)} />
        </ProductFormBox>
        </form>
        <button type='button' className='product-search-button' onClick={getNotebooks}>Search</button>
      </FormContainer>
      <NotebooksContainer>
        <p id='notebook-title'>Ricerca prodotti:</p>
        <Paragraph>
          PROMO OUTLET: Scopri tutte le categorie con prodotti scontati fino al 50%
        </Paragraph>
        <Paragraph>
          Scopri i migliori notebook dalle dimensioni ridotte, ideali per chi desidera portare il proprio dispositivo sempre con sé.
        </Paragraph>
        <Paragraph>
          <u>Vuoi acquistare un pc portatile? Scopri tutte le caratteristiche principali di un notebook.</u>
        </Paragraph>
        <Notebooks notebooks={notebooks} />
      </NotebooksContainer>
    </Wrapper>
  </Container>
  )
}


export default Products