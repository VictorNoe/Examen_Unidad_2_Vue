<template lang="">
  <b-container>
    <b-row class="mb-3">
      <b-col>
        <Carousel/>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="8" class="mb-3 d-flex justify-content-center">
        <b-button pill variant="primary">Ordenar por autor</b-button>
        <b-button pill variant="primary">Ordenar por fecha</b-button>
        <b-button pill variant="primary">Mostrar si tiene imagen</b-button>
      </b-col>
      <b-col cols="4">
        <b-button variant="primary">Gregar</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col cols="8">
        <b-row>
          <b-col cols="4" v-for="(book, index) in books" :key="index" @dragstart="handleDragStart(book.id)">
            <Cards
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
  </b-container>
</template>
<script>
import services from './services/index';
import Cards from './components/Cards.vue';
import Carousel from './components/Carousel.vue';
export default {
  data() {
    return {
      books: []
    }
  },
  components: {
    Cards,
    Carousel
  },
  methods: {
    async getBook() {
      const response = await services.getBooks();
      this.books = response;
    },
    
    async dropBook(id) {
      const response = await services.deleteBook(id);
      console.log(response);
      this.getBook()
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
      
    }
  },
  mounted() {
    this.getBook();
  },
}
</script>
<style lang="">
  
</style>