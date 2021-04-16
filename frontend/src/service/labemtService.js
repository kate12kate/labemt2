import axios from "../customaxios/axios";

const LabEmt={
    fetchBooks: ()=>{
        return axios.get("/books");

    },
    fetchCateogries: ()=>{
        return axios.get("/categories");

    },
    fetchAuthors: ()=>{
        return axios.get("/authors");

    },
    deleteBook:(id)=>{
        return axios.delete(`/books/delete/${id}`);

    },
    addBook:(name,category,author,copies)=>{
        return axios.post("/books/add",{
            "name":name,
            "category": category,
            "authorId": author,
            "availableCopies": copies

        });
    },
    editBook:(id,name,category,author,copies)=>{
        return axios.put(`/books/edit/${id}`,{
            "name":name,
            "category": category,
            "authorId": author,
            "availableCopies": copies

        });
    },
    getBook:(id)=>{
        return axios.get(`/books/${id}`);
    }

}
export default LabEmt;