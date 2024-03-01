import React from 'react'
import Notebook from './Notebook'

const Notebooks = ({notebooks}) => {
  return (
    <div>
        {
            notebooks.map((notebook , index) => (
                <Notebook key={index} notebook={notebook} />
            ))}
    </div>
  )
}

export default Notebooks