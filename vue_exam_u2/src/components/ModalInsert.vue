<template lang="">
    <div>
        <b-modal id="modal-insert" title="BootstrapVue" centered  @ok="innerBook">
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
        data: Array,
    },
    data() {
        return {
            author: null,
            name_book: null,
            publication_date: null,
        }
    },
    methods: {
        async innerBook () {
            console.log(this.publication_date);
            const response = await services.insetBook(this.author,this.name_book,this.publication_date)
            console.log(response);
            location.reload();
        },
    },
}
</script>
<style lang="">
    
</style>