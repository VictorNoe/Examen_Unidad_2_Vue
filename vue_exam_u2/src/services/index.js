import axios from "axios";

const API_URL = "http://localhost:8080/api/book/";

const getBooks = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data.data;
    } catch (error) {
        return [];
    }
};

const getAuthor = async (name_author) => {
    try {
        const response = await axios.post(API_URL + "author", {
            author: name_author
        });
        return response.data.data;
    } catch (error) {
        return [];
    }
};

const getPublication = async (publication) => {
    try {
        const response = await axios.post(API_URL + "publication", {
            publication_date: publication
        });
        return response.data.data;
    } catch (error) {
        return [];
    }
};

const insetBook = async (name_book, author_book, publication_date) => {
    try {
        const response = await axios.post(API_URL, {
            nameBook: name_book,
            author: author_book,
            publicationDate: publication_date,
            image: '',
        });
        
        return response;
    } catch (error) {
        return error;
    }
}

const deleteBook = async (id_book) => {
    try {
        const response = await axios.delete(API_URL+id_book)
        return response;
    } catch (error) {
        return error;
    }
};

const updateBook = async (id_book, name_book, author_book, publication_date, image_book) => {
    try {
        try {
            const response = await axios.post(API_URL, {
                id: id_book,
                nameBook: name_book,
                author: author_book,
                publicationDate: publication_date,
                image: image_book,
            });
            return response;
        } catch (error) {
            return error;
        }
    } catch (error) {
        return error
    }
}


export default {
    getBooks,
    getAuthor,
    getPublication,
    insetBook,
    deleteBook,
    updateBook,
}