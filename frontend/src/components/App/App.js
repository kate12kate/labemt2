import logo from '../../logo.svg';
import './App.css';
import React from "react";
import {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import LabService from "../../service/labemtService";
import Books from "../Books/BookList/bookList";
import BookEdit from "../Books/BookEdit/BookEdit";
import Categories from "../Categories/categories";
import BookAdd from "../Books/BookAdd/bookAdd";
import Header from "../Header/header";

class App extends Component{

  constructor(props) {
    super(props);
    this.state={
      books:[],
      categories:[],
        authors:[],
      selectedBook: {}
    }
  }

  render() {
    return(
        <Router>
          <Header/>
          <main>
            <div className="container">
              <Route path={"/categories"} exact render={()=>
              <Categories categories={this.state.categories}/>}/>

              <Route path={"/books/add"} exact render={()=>
              <BookAdd categories={this.state.categories}
                       onAddBook={this.addBook}
                      authors={this.state.authors}/>}/>

              <Route path={"/books/edit/:id"} exact render={()=>
              <BookEdit categories={this.state.categories}
                        authors={this.state.authors}
                        book={this.state.selectedBook}
                         onEditBook={this.editBook}/>}/>

              <Route path={"/books"} exact render={()=>
              <Books books={this.state.books}
                      onDelete={this.deleteBook}
                      onEdit={this.getBook}/>}/>
            </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
    this.loadBooks();
    this.loadCategories();
    this.loadAuthors();
  }

  loadBooks=()=>{
    LabService.fetchBooks()
        .then((data)=>{
          this.setState({
            books: data.data
          })
        });
  }
    loadAuthors=()=>{
        LabService.fetchAuthors()
            .then((data)=>{
                this.setState({
                    authors:data.data
                })
            })
    }
  loadCategories=()=>{
    LabService.fetchCateogries()
        .then((data)=>{
          this.setState({
            categories: data.data
          })
        });

  }
  deleteBook=(id)=>{
    LabService.deleteBook(id)
        .then(()=>{
          this.loadBooks();
        });
  }
  addBook=(name,categories,author,copies)=>{
    LabService.addBook(name,categories,author,copies)
        .then(()=>{
          this.loadBooks();
        });
  }
  editBook=(id,name,categories,author,copies)=>{
    LabService.editBook(id,name,categories,author,copies)
        .then(()=>{
          this.loadBooks();
        });
  }
  getBook=(id)=>{
    LabService.getBook(id)
        .then((data)=>{
          this.setState({
            selectedBook: data.data
          })
        })
  }


}

export default App;
