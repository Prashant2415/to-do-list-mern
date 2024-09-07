import React, { useState } from 'react';
import "../component/Todolist.css";
const Todolist = (props) => {
    console.log("Props ", props.todoData)
    const [inputFlag, setInputFlag] = useState(false);
    const actualData = props.todoData;
    const handleAddNewButton = () =>{
        setInputFlag(true);
    }
    const handleSubmit = (event) =>{
        event.preventDefault();
        console.log("Submit")
    }
    console.log("actaula data ",actualData)
  return (
      <div className='main-container'>
          <div className='todolist-container'>
              <div className='title-container'>
                  <h1 className='title'>To Do List</h1>
              </div>
              <br />
              <button className='add-new-button' onClick={handleAddNewButton}>Add New</button>
              <br />
              {inputFlag ?
                  <div className='form-div-container'>
                      <form className='form-container'>
                          <input className='input-area margin-gap' type='textarea' placeholder='Enter your to do' />
                          <br />
                          <input className='input-date margin-gap' type='date' />
                          <br />
                          <button className='submit-button' onClick={handleSubmit}>Submit</button>
                      </form>
                  </div>
                  : ""}
                <br/>
                <div className='display-data-container'>
                {actualData.map((data,index)=>{
                    return(
                        <div className='display-data'>
                            <input key={data.id} type='checkbox'/>
                            <li key={data.id}>{data.message}</li>
                        </div>
                    )
                })}
                </div>
          </div>
      </div>
  )
}

export default Todolist
