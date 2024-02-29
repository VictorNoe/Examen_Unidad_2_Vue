<template lang="">
    <div>
        <b-card
            :title="data.nameBook"
            :img-src="data.image"
            img-alt="Image"
            img-top
            tag="article"
            style="max-width: 20rem;"
            class="mb-2"
        >
            <b-card-text>
                <p>{{data.author}}</p>
                <p>{{data.publicationDate}}</p>
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