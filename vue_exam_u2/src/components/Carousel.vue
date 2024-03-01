<template lang="">
    <div>
        <b-carousel
            id="carousel-fade"
            :interval="3000"
            style="text-shadow: 0px 0px 2px #000"
            fade
        >
            <b-carousel-slide
              style=" min-height: 300px; max-height: 300px;"
              v-for="(book, index) in books" :key="index"
              :caption="book.nameBook"
              :img-src="book.image"
            ></b-carousel-slide> 
        </b-carousel>
    </div>
</template>
<script>
import services from "../services/index";
export default {
  data() {
    return {
      books: [],
    };
  },
  methods: {
    async getBook() {
      const response = await services.getBooks();
      this.books = response;
    },
  },
  mounted() {
    this.getBook();
  },
};
</script>
<style lang="">
</style>