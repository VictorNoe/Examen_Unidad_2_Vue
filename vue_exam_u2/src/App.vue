<template lang="">
  <b-container>
    <b-row class="mb-3">
      <b-col>
        <Carousel/>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="8" class="mb-3 d-flex justify-content-center">
        <b-button pill variant="primary" @click="getByAuthors">Ordenar por autor</b-button>
        <b-button pill variant="primary"  @click="getBypublicationDate">Ordenar por fecha</b-button>
        <b-button pill variant="primary" @click="getImage">Mostrar si tiene imagen</b-button>
      </b-col>
      <b-col cols="4">
        <b-button variant="primary" v-b-modal.modal-insert>Agregar</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="8">
        <b-row>
          <b-col cols="4" v-for="(book, index) in books" :key="index" @dragstart="handleDragStart(book.id)">
            <Cards
              class="animate__animated animate__bounce"
              :data="book"
            />
          </b-col>
        </b-row>
      </b-col>
      <b-col cols="4">
        <b-row @dragover.prevent @drop="heandleInsert">
          <b-col md="12" class="mb-3">
            <div>
              <b-icon class="p-3 border border-2" icon="pencil" style="width: 200px; height: 200px;"></b-icon>
            </div>
          </b-col>
        </b-row>
        <b-row @dragover.prevent @drop="heandleDelete">
          <b-col md="12" class="mb-3">
            <div>
              <b-icon class="p-3 border border-2" icon="trash" style="width: 200px; height: 200px;"></b-icon>
            </div>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
    <ModalInsert
      :data="books"
    />
    <div>
        <b-modal id="modal-update" title="BootstrapVue" centered @ok="updateBook">
            <label for="">Autor</label>
            <b-form-input type="text" v-model="author"></b-form-input>
            <label for="">Nombre libro</label>
            <b-form-input type="text" v-model="name_book"></b-form-input>
            <label for="">Fecha de publicación</label>
            <b-form-input type="date" v-model="publication_date"></b-form-input>
        </b-modal>
    </div>
  </b-container>
  
</template>
<script>
import services from './services/index';
import Cards from './components/Cards.vue';
import Carousel from './components/Carousel.vue';
import ModalInsert from './components/ModalInsert.vue';
import ModalUpdate from './components/ModalUpdate.vue';
export default {
  data() {
    return {
      id: null,
      author: null,
      name_book: null,
      publication_date: null,
      books: [],
      bookUpdate: {},
    };
  },
  components: {
    Cards,
    Carousel,
    ModalInsert,
    ModalUpdate
  },
  methods: {
    async getBook() {
      const response = await services.getBooks();
      this.books = response;
    },
    async getByAuthors() {
      const response = await services.getAuthor();
      this.books = response;
    },
    async getBypublicationDate() {
      const response = await services.getPublication();
      this.books = response;
    },
    async getImage() {
      const response = await services.getImage();
      this.books = response;
    },
    async dropBook(id) {
      const response = await services.deleteBook(id);
      console.log(response);
      this.getBook();
    },
    async updateBook() {
      console.log(this.publication_date);
      const response = await services.updateBook(this.id, this.author, this.name_book, this.publication_date)
      console.log(response);
      this.getBook();
    },
    handleDragStart(index) {
      event.dataTransfer.setData("text/plain", index);
    },

    heandleDelete(event) {
      event.preventDefault();
      const index = event.dataTransfer.getData("text/plain");
      this.dropBook(index);
    },
    heandleInsert(event) {
      event.preventDefault();
      const index = event.dataTransfer.getData("text/plain");
      for (let i = 0; i < this.books.length; i++) {
        if (this.books[i].id === parseInt(index)) {
          this.id = this.books[i].id;
          this.author = this.books[i].author
          this.name_book = this.books[i].nameBook
          this.publication_date = this.books[i].publicationDate
          break;
        }

      }
      this.$bvModal.show("modal-update")
    }
  },
  mounted() {
    this.getBook();
  },
};
</script>
<style lang="">
</style>