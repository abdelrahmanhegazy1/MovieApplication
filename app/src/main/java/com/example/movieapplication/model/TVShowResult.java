package com.example.movieapplication.model;

import java.io.Serializable;
import java.util.List;

public class TVShowResult implements Serializable {

    /**
     * page : 1
     * total_results : 10000
     * total_pages : 500
     * results : [{"original_name":"The Boys","genre_ids":[10759,10765],"name":"The Boys","popularity":2165.929,"origin_country":["US"],"vote_count":2866,"first_air_date":"2019-07-25","backdrop_path":"/mGVrXeIjyecj6TKmwPVpHlscEmw.jpg","original_language":"en","id":76479,"vote_average":8.4,"overview":"A group of vigilantes known informally as \u201cThe Boys\u201d set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.","poster_path":"/mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg"},{"original_name":"Lucifer","genre_ids":[80,10765],"name":"Lucifer","popularity":900.816,"origin_country":["US"],"vote_count":5742,"first_air_date":"2016-01-25","backdrop_path":"/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg","original_language":"en","id":63174,"vote_average":8.5,"overview":"Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.","poster_path":"/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"},{"original_name":"The Walking Dead: World Beyond","genre_ids":[18,10765],"name":"The Walking Dead: World Beyond","popularity":778.639,"origin_country":["US"],"vote_count":144,"first_air_date":"2020-10-04","backdrop_path":"/pLVrN9B750ehwTFdQ6n3HRUERLd.jpg","original_language":"en","id":94305,"vote_average":7.8,"overview":"A heroic group of teens sheltered from the dangers of the post-apocalyptic world leave the safety of the only home they have ever known and embark on a cross-country journey to find the one man who can possibly save the world.","poster_path":"/z31GxpVgDsFAF4paZR8PRsiP16D.jpg"},{"original_name":"Fear the Walking Dead","genre_ids":[18,10759],"name":"Fear the Walking Dead","popularity":476.235,"origin_country":["US"],"vote_count":2184,"first_air_date":"2015-08-23","backdrop_path":"/58PON1OrnBiX6CqEHgeWKVwrCn6.jpg","original_language":"en","id":62286,"vote_average":7.3,"overview":"What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.","poster_path":"/wGFUewXPeMErCe2xnCmmLEiHOGh.jpg"},{"original_name":"Riverdale","genre_ids":[18,9648],"name":"Riverdale","popularity":456.553,"origin_country":["US"],"vote_count":5724,"first_air_date":"2017-01-26","backdrop_path":"/9hvhGtcsGhQY58pukw8w55UEUbL.jpg","original_language":"en","id":69050,"vote_average":8.6,"overview":"Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale\u2019s wholesome facade.","poster_path":"/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg"},{"original_name":"The 100","genre_ids":[18,10759,10765],"name":"The 100","popularity":484.692,"origin_country":["US"],"vote_count":4577,"first_air_date":"2014-03-19","backdrop_path":"/hTExot1sfn7dHZjGrk0Aiwpntxt.jpg","original_language":"en","id":48866,"vote_average":7.7,"overview":"100 years in the future, when the Earth has been abandoned due to radioactivity, the last surviving humans live on an ark orbiting the planet \u2014 but the ark won't last forever. So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.","poster_path":"/wcaDIAG1QdXQLRaj4vC1EFdBT2.jpg"},{"original_name":"Supernatural","genre_ids":[18,9648,10765],"name":"Supernatural","popularity":395.205,"origin_country":["US"],"vote_count":3954,"first_air_date":"2005-09-13","backdrop_path":"/nVRyd8hlg0ZLxBn9RaI7mUMQLnz.jpg","original_language":"en","id":1622,"vote_average":8,"overview":"When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ","poster_path":"/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"},{"original_name":"The Walking Dead","genre_ids":[18,10759,10765],"name":"The Walking Dead","popularity":453.516,"origin_country":["US"],"vote_count":8028,"first_air_date":"2010-10-31","backdrop_path":"/wXXaPMgrv96NkH8KD1TMdS2d7iq.jpg","original_language":"en","id":1402,"vote_average":7.9,"overview":"Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.","poster_path":"/qgjP2OrrX9gc6M270xdPnEmE9tC.jpg"},{"original_name":"Grey's Anatomy","genre_ids":[18],"name":"Grey's Anatomy","popularity":340.443,"origin_country":["US"],"vote_count":3753,"first_air_date":"2005-03-27","backdrop_path":"/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg","original_language":"en","id":1416,"vote_average":8,"overview":"Follows the personal and professional lives of a group of doctors at Seattle\u2019s Grey Sloan Memorial Hospital.","poster_path":"/jnsvc7gCKocXnrTXF6p03cICTWb.jpg"},{"original_name":"The Simpsons","genre_ids":[16,35,18,10751],"name":"The Simpsons","popularity":351.928,"origin_country":["US"],"vote_count":4849,"first_air_date":"1989-12-16","backdrop_path":"/adZ9ldSlkGfLfsHNbh37ZThCcgU.jpg","original_language":"en","id":456,"vote_average":7.7,"overview":"Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.","poster_path":"/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"},{"original_name":"The Good Doctor","genre_ids":[18],"name":"The Good Doctor","popularity":335.944,"origin_country":["US"],"vote_count":5083,"first_air_date":"2017-09-25","backdrop_path":"/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg","original_language":"en","id":71712,"vote_average":8.6,"overview":"A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?","poster_path":"/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg"},{"original_name":"Cobra Kai","genre_ids":[18,10759],"name":"Cobra Kai","popularity":400.1,"origin_country":["US"],"vote_count":894,"first_air_date":"2018-05-02","backdrop_path":"/g63KmFgqkvXu6WKS23V56hqEidh.jpg","original_language":"en","id":77169,"vote_average":8,"overview":"This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.","poster_path":"/eTMMU2rKpZRbo9ERytyhwatwAjz.jpg"},{"original_name":"The Flash","genre_ids":[18,10765],"name":"The Flash","popularity":358.333,"origin_country":["US"],"vote_count":5841,"first_air_date":"2014-10-07","backdrop_path":"/z59kJfcElR9eHO9rJbWp4qWMuee.jpg","original_language":"en","id":60735,"vote_average":7.5,"overview":"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.","poster_path":"/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"},{"original_name":"Emily in Paris","genre_ids":[35,18],"name":"Emily in Paris","popularity":464.73,"origin_country":["US"],"vote_count":115,"first_air_date":"2020-10-02","backdrop_path":"/iW74tZ8y2qobdpt4J9UQ71sw8q7.jpg","original_language":"en","id":82596,"vote_average":8.1,"overview":"When ambitious Chicago marketing exec Emily unexpectedly lands her dream job in Paris, she embraces a new life as she juggles work, friends and romance.","poster_path":"/kwMqIYOC4U9eK4NZnmmyD8pDEOi.jpg"},{"original_name":"The Vampire Diaries","genre_ids":[18,14,27,10749],"name":"The Vampire Diaries","popularity":349.465,"origin_country":["US"],"vote_count":3731,"first_air_date":"2009-09-10","backdrop_path":"/k7T9xRyzP41wBVNyNeLmh8Ch7gD.jpg","original_language":"en","id":18165,"vote_average":8.3,"overview":"The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.","poster_path":"/b3vl6wV1W8PBezFfntKTrhrehCY.jpg"},{"original_name":"Game of Thrones","genre_ids":[18,9648,10759,10765],"name":"Game of Thrones","popularity":338.158,"origin_country":["US"],"vote_count":10865,"first_air_date":"2011-04-17","backdrop_path":"/suopoADq0k8YZr4dQXcU6pToj6s.jpg","original_language":"en","id":1399,"vote_average":8.3,"overview":"Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.","poster_path":"/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"},{"original_name":"The Umbrella Academy","genre_ids":[35,18,10759,10765],"name":"The Umbrella Academy","popularity":337.283,"origin_country":["US"],"vote_count":2759,"first_air_date":"2019-02-15","backdrop_path":"/qJxzjUjCpTPvDHldNnlbRC4OqEh.jpg","original_language":"en","id":75006,"vote_average":8.7,"overview":"A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.","poster_path":"/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"},{"original_name":"Raised by Wolves","genre_ids":[18,10765],"name":"Raised by Wolves","popularity":322.755,"origin_country":["US"],"vote_count":362,"first_air_date":"2020-09-03","backdrop_path":"/na2xUduK8HviOFT97TiFG2MkJmY.jpg","original_language":"en","id":85723,"vote_average":7.7,"overview":"After Earth is ravaged by a great religious war, an atheistic android architect sends two of his creations, Mother and Father, to start a peaceful, godless colony on the planet Kepler-22b. Their treacherous task is jeopardized by the arrival of the Mithraic, a deeply devout religious order of surviving humans.","poster_path":"/mTvSVKMn2Npf6zvYNbGMJnYLtvp.jpg"},{"original_name":"La casa de papel","genre_ids":[80,18],"name":"Money Heist","popularity":312.172,"origin_country":["ES"],"vote_count":10348,"first_air_date":"2017-05-02","backdrop_path":"/xGexTKCJDkl12dTW4YCBDXWb1AD.jpg","original_language":"es","id":71446,"vote_average":8.3,"overview":"To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.","poster_path":"/MoEKaPFHABtA1xKoOteirGaHl1.jpg"},{"original_name":"Scorpion","genre_ids":[80,18,10759],"name":"Scorpion","popularity":268.388,"origin_country":["US"],"vote_count":1338,"first_air_date":"2014-09-22","backdrop_path":"/iZIZFDO9ZoBcHWz0CvkwbME7kOp.jpg","original_language":"en","id":60797,"vote_average":8.1,"overview":"Based on a true story, Scorpion is a high-octane drama about eccentric genius Walter O\u2019Brien and his team of brilliant misfits who comprise the last line of defense against complex, high-tech threats of the modern age. As Homeland Security\u2019s new think tank, O\u2019Brien\u2019s \u201cScorpion\u201d team includes Toby Curtis, an expert behaviorist who can read anyone; Happy Quinn, a mechanical prodigy; and Sylvester Dodd, a statistics guru.","poster_path":"/hzeirSF6bRjssDh5JFrm5WRwFLd.jpg"}]
     */

    private int page;
    private int total_results;
    private int total_pages;
    private List<ResultsBean> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Serializable{
        /**
         * original_name : The Boys
         * genre_ids : [10759,10765]
         * name : The Boys
         * popularity : 2165.929
         * origin_country : ["US"]
         * vote_count : 2866
         * first_air_date : 2019-07-25
         * backdrop_path : /mGVrXeIjyecj6TKmwPVpHlscEmw.jpg
         * original_language : en
         * id : 76479
         * vote_average : 8.4
         * overview : A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.
         * poster_path : /mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg
         */

        private String original_name;
        private String name;
        private double popularity;
        private int vote_count;
        private String first_air_date;
        private String backdrop_path;
        private String original_language;
        private int id;
        private double vote_average;
        private String overview;
        private String poster_path;
        private List<Integer> genre_ids;
        private List<String> origin_country;

        public String getOriginal_name() {
            return original_name;
        }

        public void setOriginal_name(String original_name) {
            this.original_name = original_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public String getFirst_air_date() {
            return first_air_date;
        }

        public void setFirst_air_date(String first_air_date) {
            this.first_air_date = first_air_date;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }

        public List<String> getOrigin_country() {
            return origin_country;
        }

        public void setOrigin_country(List<String> origin_country) {
            this.origin_country = origin_country;
        }
    }
}
