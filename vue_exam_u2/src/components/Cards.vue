<template lang="">
    <div>
        <b-card
            :title="data.name_book"
            img-src="https://picsum.photos/600/300/?image=25"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem;"
            class="mb-2"
        >
            <b-card-text>
                <p>{{data.author}}</p>
                <p>{{data.publication_date}}</p>
            </b-card-text>
        </b-card>
    </div>
</template>
<script>
export default {
    props: {
        data: Object
    },
}
</script>
<style lang="">
    
</style>