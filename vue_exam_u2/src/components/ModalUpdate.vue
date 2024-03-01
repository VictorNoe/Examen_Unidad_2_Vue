<template lang="">
    <div>
        <b-modal id="modal-update" title="BootstrapVue" centered  @ok="updateBook">
            <label for="">Autor</label>
            <b-form-input type="text" v-model="author"></b-form-input>
            <label for="">Nombre libro</label>
            <b-form-input type="text" v-model="name_book"></b-form-input>
            <label for="">Fecha de publicación</label>
            <b-form-input type="date" v-model="publication_date"></b-form-input>
        </b-modal>
    </div>
</template>
<script>
import services from '../services';
export default {
    props: {
        book: Array,
    },
    data() {
        return {
            id: null,
            author: null,
            name_book: null,
            publication_date: null,
            data: book
        }
    },
    mounted() {
        console.log(book);
        this.data = this.book;
        this.info();
    },
    methods: {
        info() {
            this.id = this.data.id;
            this.author = this.data.author
            this.name_book = this.data.nameBook
            this.publication_date = this.data.publicationDate
        },
        async updateBook () {
            console.log(this.publication_date);
            const response = await services.updateBook(this.id, this.author,this.name_book,this.publication_date)
            console.log(response);
            location.reload();
        },
    },
}
</script>
<style lang="">
    
</style>