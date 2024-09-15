import React, { useEffect, useState } from 'react';
import "../component/Todolist.css";
import axios from "axios";

const Todolist = (props) => {
    console.log("Props ", props.todoData)
    const [inputFlag, setInputFlag] = useState(false);
    const actualData = props.todoData;

    const [todo,setTodo] = useState(actualData);
    const [newTodo, setNewTodo] = useState({message:"", dateTime:"",check:"true"});

    const handleAddNewButton = () =>{
        setInputFlag(true);
    }
    
    const handleSubmit =(e)=>{
        e.preventDefault();
        axios.post("http://localhost:8080/todo/save",newTodo).then(response =>{
            setTodo(...todo.length + 1,response.data);
            setNewTodo({ message: "", dateTime: "", check: false });
        })
        .catch(error => console.log("error ",error))
        
        window.location.reload(); // added to make the page reload so it will call end backend get all todo list api 
    }

    const handleClearAll = ()=>{
        console.log("Clear all")
        axios.delete(`http://localhost:8080/todo/deleteAll`)

        window.location.reload();
    }
    const handleClearSpecific = async(specificId)=>{
        console.log("Specific id ",specificId);
        axios.delete(`http://localhost:8080/todo/deleteById/${specificId}`)

        window.location.reload();
    }

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
                      <form className='form-container'  onSubmit={handleSubmit}>
                          <input className='input-area margin-gap' type='text' onChange={(e) => setNewTodo({ ...newTodo, message: e.target.value })} placeholder='Enter your to do' />
                          <br />
                          <input className='input-date margin-gap' onChange={(e) => setNewTodo({ ...newTodo, dateTime: e.target.value })} type='datetime-local' />
                          <br />
                          <button className='submit-button'>Submit</button>
                      </form>
                  </div>
                  : ""}
                <br/>
                <div className='display-data-container'>
                    <h1 className='display-data-title'>Task to Complete</h1>
                    <button className='clear-all-button' onClick={handleClearAll}>Clear All</button>
                {actualData.map((data,index)=>{
                    return(
                        <div className='display-data'>
                            <input key={data.id} type='checkbox'/>
                            <li key={data.id} className='display-message'>{data.message}</li>
                            <button key={data.id} className='cross-specific' onClick={()=>{handleClearSpecific(data.todoid)}}>x</button>
                        </div>
                    )
                })}
                </div>
          </div>
      </div>
  )
}

export default Todolist
