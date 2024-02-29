<template lang="">
    <div class="h-50">
        <b-carousel
            id="carousel-fade"
            style="text-shadow: 0px 0px 2px #000"
            fade
            indicators
            img-width="1080"
            img-height="200"

        >
            <b-carousel-slide
         
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