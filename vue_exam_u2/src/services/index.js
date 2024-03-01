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

const getAuthor = async () => {
    try {
        const response = await axios.get(API_URL + "author");
        return response.data.data;
    } catch (error) {
        return [];
    }
};

const getPublication = async () => {
    try {
        const response = await axios.get(API_URL + "publication");
        return response.data.data;
    } catch (error) {
        return [];
    }
};

const getImage = async () => {
    try {
        const response = await axios.get(API_URL + "image");
        return response.data.data;
    } catch (error) {
        return [];
    }
};

const insetBook = async (name_book, author_book, publication_date) => {
    try {
        const response = await axios.post(API_URL, {
            author: author_book,
            nameBook: name_book,
            publicationDate: publication_date
        });
        return;
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

const updateBook = async (id_book, author_book, name_book, publication_date) => {
    try {
        try {
            const response = await axios.post(API_URL, {
                id: id_book,
                author: author_book,
                nameBook: name_book,
                publicationDate: publication_date,
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
    getImage
}