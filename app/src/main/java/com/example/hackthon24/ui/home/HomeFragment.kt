package com.example.hackthon24.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackthon24.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ChildAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val parentItems = listOf(
            ParentItem.ParentTypeA(
                "GOA",
                listOf(
                    ChildItem.ChildTypeA(
                        "Baga Beach",
                        "Popular beach with vibrant nightlife",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/3e/36/95/baga-sea-beach.jpg?w=1200&h=1200&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Anjuna Beach",
                        "Known for its lively parties and markets",
                        "https://media1.thrillophilia.com/filestore/z78kadyl2dqn37ryd9gi6hhxs09q_925047350s.jpg?dpr=2&w=400"
                    ),
                    ChildItem.ChildTypeA(
                        "Calangute Beach",
                        "One of the busiest beaches in Goa",
                        "https://cdn.thegoavilla.com/static/img/articles/calangute-beach.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Palolem Beach",
                        "A serene and scenic beach",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS19rv286dqp3MbeYO4wWFQL3BlCNG5cgaNIA&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Vagator Beach",
                        "Famous for its scenic beauty and parties",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSH3-GUoth0ak4SNi8bYXHhu2OgY2Wo14pW6Q&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Candolim Beach",
                        " Peaceful, uncrowded, water sports",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlwVBC0o4dH8vX6GqLfZF87tKS8qjJoS4jfA&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Miramar Beach",
                        "Close to Panaji, sunset views.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV1OfmwKYlKlXPCMQ9C8xt4zC0lLq68yLXoQ&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Colva Beach",
                        " White sand, lively, nightlife.",
                        "https://upload.wikimedia.org/wikipedia/commons/0/06/Colv%C3%A1_beach.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Morjim Beach",
                        "Turtle nesting, Russian tourists",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuI97lrB7Vjy12IGCHv2dvGxPuyyvE-FrFCg&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Arambol Beach",
                        "Bohemian, yoga, international travelers",
                        "https://media1.thrillophilia.com/filestore/8asovra9hft5e4vfhl54o9hg0gha_arambol_beach.jpg"
                    )
                )
            ),
            ParentItem.ParentTypeA(
                "MAHARASHTRA",
                listOf(
                    ChildItem.ChildTypeA(
                        "Juhu Beach",
                        "A bustling beach in Mumbai, known for its vibrant atmosphere.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/ab/77/f9/img-20190525-192344-01.jpg?w=900&h=-1&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Marine Drive",
                        "The iconic Marine Drive offers a scenic beachside promenade.",
                        "https://static.wanderon.in/wp-content/uploads/2024/04/marine-drive-2.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Girgaum Chowpatty",
                        "A popular spot in Mumbai for evening walks and street food.",
                        "https://www.mapsofindia.com/ci-moi-images/my-india/2014/11/the-setting-sun-at-girgaum-chowpatty-665x442.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Versova Beach",
                        "Famous for its clean sands, thanks to local cleanup efforts.",
                        "https://mumbaitourism.travel/images/places-to-visit/headers/versova-beach-mumbai-indian-tourism-entry-fee-timings-holidays-reviews-header.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Aksa Beach",
                        "A quieter beach, away from the city's hustle.",
                        "https://mumbaitourism.travel/images/places-to-visit/headers/aksa-beach-mumbai-indian-tourism-entry-fee-timings-holidays-reviews-header.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Ganpatipule Beach",
                        "Known for its temple and picturesque surroundings.",
                        "https://miro.medium.com/v2/resize:fit:720/format:webp/0*jMiDTBucaPCLUd4Z.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Kashid Beach",
                        "A tranquil beach with white sands and clear waters.",
                        "https://alibagtourism.com/wp-content/uploads/2023/02/Kashid-Beach-1536x863.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Mandwa Beach",
                        "A peaceful beach perfect for weekend getaways from Mumbai.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5Tcimty8OTYU__GimNqRc4kXJBT4XXukX2A&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Murud Beach",
                        "A serene beach with the famous Murud-Janjira Fort.",
                        "data:image/jpeg;base64,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 "
                    ),
                    ChildItem.ChildTypeA(
                        "Tarkarli Beach",
                        "Famous for its clear waters and underwater activities.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/19/79/56/tarkarli-beach.jpg?w=900&h=-1&s=1"
                    )
                )
            ),

            ParentItem.ParentTypeA(
                "KARNATAKA",
                listOf(
                    ChildItem.ChildTypeA(
                        "Gokarna Beach",
                        "A sacred beach known for its pilgrimage importance and scenic beauty.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/03/53/5e/7f/om-beach.jpg?w=1400&h=500&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Om Beach",
                        "Famous for its Om-shaped coastline and peaceful atmosphere.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/6e/8e/a8/om-beach.jpg?w=900&h=-1&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Kudle Beach",
                        "A serene beach perfect for a tranquil getaway.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/e7/8b/c8/img-20180930-073858-largejpg.jpg?w=900&h=500&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Murudeshwar Beach",
                        "Known for the majestic statue of Lord Shiva and its serene waters.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/73/8a/ad/murudeshwar.jpg?w=900&h=500&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Malpe Beach",
                        "A clean beach with water sports and a nearby island to explore.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/b8/7b/31/malpe.jpg?w=300&h=300&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Karwar Beach",
                        "A less crowded, peaceful beach with clean waters.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/01/90/f9/ravindranath-tagore-beach.jpg?w=800&h=-1&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Ullal Beach",
                        "A tranquil beach in Mangalore with golden sands.",
                        "https://mangaloretourism.in/images/places-to-visit/header/ullal-beach-mangalore-tourism-entry-fee-timings-holidays-reviews-header.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Panambur Beach",
                        "Known for its cleanliness and water sports facilities.",
                        "https://mangaloretourism.in/images/places-to-visit/header/panambur-beach-mangalore-tourism-entry-fee-timings-holidays-reviews-header.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Kaup Beach",
                        "Famous for its lighthouse and scenic beauty.",
                        "https://i.ytimg.com/vi/zSf5HiY9gsM/maxresdefault.jpg"
                    )
                )
            ),

            ParentItem.ParentTypeA(
                "KERALA",
                listOf(
                    ChildItem.ChildTypeA(
                        "Kovalam Beach",
                        "A popular beach with clear waters and iconic lighthouses.",
                        "https://media-cdn.tripadvisor.com/media/photo-c/1280x250/05/12/dd/fa/kovalam.jpg "
                    ),
                    ChildItem.ChildTypeA(
                        "Varkala Beach",
                        "A cliffside beach offering stunning views and relaxing spots.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhEgSVGKhs2P2nCFVYcuJaDYLdNx2jNSznag&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Alappuzha Beach",
                        "A peaceful beach known for its houseboats and backwaters.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8QaQGjVl4AngHASkaOxB_lvjUhChcJM_Jyw&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Cherai Beach",
                        "A less crowded beach with a beautiful view of the Arabian Sea.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/20/44/7f/cherai-beach.jpg?w=1200&h=-1&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Marari Beach",
                        "A pristine beach with golden sands and tranquil waters.",
                        "https://www.keralatourism.org/images/enchanting_kerala/large/marari_beach_alappuzha20220730073122_1204_1.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Bekal Beach",
                        "Famous for the Bekal Fort and scenic surroundings.",
                        "https://www.keralatourism.org/images/picture/thumb/Bekal_Fort_1827.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Payyambalam Beach",
                        "A serene beach in Kannur known for its clean sands.",
                        "https://kannurairport.aero/kial/public/uploads/destination_img/wBxmORxUi90NpmwsQ7PVIT6NKoV1a6.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Muzhappilangad Beach",
                        "Kerala’s only drive-in beach, perfect for adventure seekers.",
                        "https://content.jdmagicbox.com/comp/kannur/c7/9999px497.x497.170603150936.l3c7/catalogue/muzhappilangad-drive-in-beach-muzhappilangad-kannur-uoegpm0l7g.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Kappad Beach",
                        "A historic beach where Vasco da Gama landed in 1498.",
                        "https://www.keralatourism.org/images/destination/large/kappad_beach_kozhikode20150811120517_257_1.jpg"
                    )
                )
            ),

            ParentItem.ParentTypeA(
                "TAMIL NADU",
                listOf(
                    ChildItem.ChildTypeA(
                        "Marina Beach ",
                        "The longest urban beach in India, known for its vibrant atmosphere.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX5rTeotFjBHHbGUTOjzqIGPxtT-GNrKf8RQ&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Elliot’s Beach ",
                        "A quieter and more peaceful alternative to Marina Beach.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIohkbp0Xdd3L1xOciSFmrYq6lqhC0MTYgzQ&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Mahabalipuram Beach",
                        "Famous for its historic temples and UNESCO World Heritage Sites.",
                        "https://travelsetu.com/apps/uploads/new_destinations_photos/destination/2023/12/21/5468bcb2a5a0902e29b3b0fd29e0a9d1_1000x1000.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Kanyakumari Beach",
                        "A famous beach at the southern tip of India with stunning sunsets.",
                        "https://www.oyorooms.com/travel-guide/wp-content/uploads/2019/11/view-from-kanyakumari-beach-1280x720.webp"
                    ),
                    ChildItem.ChildTypeA(
                        "Rameswaram Beach",
                        "Known for its crystal-clear waters and sacred significance.",
                        "https://static.toiimg.com/photo/59284178.cms"
                    ),
                    ChildItem.ChildTypeA(
                        "Poompuhar Beach",
                        "A historic beach linked to the ancient Chola dynasty.",
                        "https://www.tamilnadutourism.tn.gov.in/img/pages/large-desktop/poompuhar-beach-1657995241_e16565ab832e1ee0c8a7.webp"
                    ),
                    ChildItem.ChildTypeA(
                        "Silver Beach",
                        "A quiet, long stretch of beach perfect for relaxation.",
                        "https://upload.wikimedia.org/wikipedia/commons/2/24/Silver_Beach_New.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Thiruvanmiyur Beach",
                        "A peaceful beach near Chennai ideal for a relaxing walk.",
                        "https://yometro.com/images/places/thiruvanmiyur-beach.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "VGP Golden Beach",
                        "A family-friendly beach near the amusement park.",
                        "https://www.tamilnadutourism.tn.gov.in/img/pages/large-desktop/vgp-golden-beach-1657265111_607ab68302dabca3dd84.webp"
                    ),
                    ChildItem.ChildTypeA(
                        "Dhanushkodi Beach",
                        "A mystical beach with ruins of an old town and a serene coastline.",
                        "https://static.india.com/wp-content/uploads/2022/08/Dhanushkodi-f.jpg?impolicy=Medium_Resize&w=1200&h=800"
                    ),
                    ChildItem.ChildTypeA(
                        "Covelong Beach",
                        "Popular for its surfing and water sports",
                        "https://www.rajasthantourplanner.com/images/Covelong-Beach.jpg"
                    )
                )
            ),

            ParentItem.ParentTypeA(
                "ANDHRA PRADESH",
                listOf(
                    ChildItem.ChildTypeA(
                        "Rushikonda Beach",
                        "A scenic beach with golden sands and calm waters.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgp8yQSaa5PTqhkWRG_dnEPt605A44qHHZVg&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Yarada Beach",
                        "A secluded beach surrounded by lush green hills.",
                        "https://www.holidify.com/images/compressed/5095.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Bheemunipatnam Beach",
                        "A quiet beach known for its peaceful ambiance.",
                        "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/8e/ce/5b/bheemili-beach.jpg?w=1200&h=-1&s=1"
                    ),
                    ChildItem.ChildTypeA(
                        "Rishikonda Beach",
                        "Popular for water sports and scenic views.",
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Rushikonda_beach_view_001.jpg/1200px-Rushikonda_beach_view_001.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Mypadu Beach",
                        "A serene beach perfect for relaxing by the sea.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStkuKM06b7RvRMMCNVQruyDNlCROLeVHOlaQ&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Kakinada Beach",
                        "A calm and clean beach with stunning views.",
                        "https://www.oyorooms.com/travel-guide/wp-content/uploads/2019/12/shutterstock_1087132073-1280x720.webp"
                    ),
                    ChildItem.ChildTypeA(
                        "Ramakrishna Beach ",
                        "A famous beach known for its lively atmosphere.",
                        "https://live.staticflickr.com/4368/35950869773_9662e0af97_b.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Suryalanka Beach",
                        "A peaceful getaway for those looking to unwind.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpZNfzchzPHVN5LL_muWCwWA1M82v1shRqew&s"
                    )
                )
            ),

            ParentItem.ParentTypeA(
                "ODISHA",
                listOf(
                    ChildItem.ChildTypeA(
                        "Puri Beach",
                        "One of the most famous beaches near the Jagannath Temple.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGlHjfCOYAAhkBoF1XsxGHT8lO7oQyJvrr3Q&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Chandipur Beach",
                        "Known for the sea receding phenomenon during low tide.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ09tvPNLfvgRdIvdToVEbOJof5VhuWJTvZIg&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Gopalpur Beach",
                        "A quiet beach known for its scenic beauty.",
                        "https://upload.wikimedia.org/wikipedia/commons/9/9b/Gopalpur_%27s_busy_beach.JPG"
                    ),
                    ChildItem.ChildTypeA(
                        "Astaranga Beach",
                        "A less crowded beach with beautiful sunsets.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSF6RiHIg7_FhE9-gqxEEUR-KDFOgV8z1bfSg&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Chandrabhaga Beach",
                        "A scenic beach near the Konark Sun Temple.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_MuT_Qr4rXQ4a1nsqAhIRj1WblznyHx5y-A&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Balighai Beach",
                        "A serene beach with beautiful casuarina trees.",
                        "https://content3.jdmagicbox.com/comp/puri/p4/9999p6752.6752.170315151123.j1p4/catalogue/balighai-beach-beldal-puri-tourist-attraction-nd739ph.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Ramchandi Beach",
                        "A calm beach perfect for a relaxing day out.",
                        "https://www.holidify.com/images/cmsuploads/compressed/ramchandi_20180926132020.png"
                    ),
                    ChildItem.ChildTypeA(
                        "Paradip Beach",
                        "A popular beach known for its port and cleanliness.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRI6gSm93uKmzEzMleGj7bpXuTlya0eQPnwgQ&s"
                    )
                )
            ),

            ParentItem.ParentTypeA(
                "WEST BENGAL",
                listOf(
                    ChildItem.ChildTypeA(
                        "Digha Beach",
                        "A popular beach destination known for its shallow waters.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLWXZ-fcV8O8-WxrXny2GJd8fRclrvPjwjovdQTHlnilXZR9qlB7qdsjn42UVvL44gs4U&usqp=CAU"
                    ),
                    ChildItem.ChildTypeA(
                        "Mandarmani Beach",
                        "Famous for its motorable beach stretch and tranquil vibes.",
                        "https://hblimg.mmtcdn.com/content/hubble/img/mandarmani/mmt/activities/t_ufs/m_activities-mandarmani-shankarpur-beach_l_400_640.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Shankarpur Beach",
                        "A quiet and clean beach near Mandarmani.",
                        "https://static2.tripoto.com/media/filter/tst/img/2232732/TripDocument/1663513147_img_20220918_202503.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Tajpur Beach",
                        "A peaceful beach with a long shoreline and red crabs.",
                        "https://nomadicweekends.com/blog/wp-content/uploads/2019/03/Tajpur-Sea-Beach.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Bakkhali Beach",
                        "A serene and isolated beach perfect for relaxation.",
                        "https://priyatravels.in/wp-content/uploads/2021/02/Bakkhali-Beach-Kolkata.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Sagar Island Beach",
                        "A religious beach known for its annual Ganga Sagar Mela.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRS851II8FdOSY7OUDGb4djGeQLwW-YSkJwvylh9N80_1tBbUPCeuql__DN3XlLy66yoYY&usqp=CAU"
                    )
                )
            ),

            ParentItem.ParentTypeA(
                "GUJARAT",
                listOf(
                    ChildItem.ChildTypeA(
                        "Gir Somnath Beach",
                        "Popular for its scenic beauty and Gir National Park",
                        "https://travelsetu.com/apps/uploads/new_destinations_photos/destination/2023/12/19/2299db82e5e209770089de7d25adef28_1000x1000.png"
                    ),
                    ChildItem.ChildTypeA(
                        "Diu Beach",
                        "Known for its serene environment and historic fort",
                        "https://media-cdn.tripadvisor.com/media/photo-s/09/b2/14/bf/nagoa-beach.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Mandvi Beach",
                        "A tranquil beach with less crowd",
                        "https://www.gujarattourism.com/content/dam/gujrattourism/images/june/Mandvi-Beach-thumbnail.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Kutch Beach",
                        "Offers unique salt desert and coastal views",
                        "https://hblimg.mmtcdn.com/content/hubble/img/Kutch/mmt/activities/t_ufs/m_activities_kutch_mandvi_beach_l_442_789.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Dwarka Beach",
                        "A sacred beach near the Dwarkadhish Temple.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmT0YI-8BrmOBxDh1zIfjzWWPecDDL6lPoKA&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Ghoghla Beach",
                        "A clean and quiet beach perfect for water sports.",
                        "https://content.jdmagicbox.com/comp/diu/m5/9999p2875.2875.141218103131.g8m5/catalogue/ghoghla-beach-ghoghla-diu-tourist-attraction-1ckfksa.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Tithal Beach",
                        "A famous black-sand beach known for its scenic beauty.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQszufLBE9d8x_LUa8oh29JC38FaGQykUJRSg&s"
                    ),
                    ChildItem.ChildTypeA(
                        "Nargol Beach",
                        "A peaceful and isolated beach, ideal for relaxation.",
                        "https://www.gujarattourism.com/content/dam/gujrattourism/images/march/april/images/nargol%20beach.jpg"
                    ),
                    ChildItem.ChildTypeA(
                        "Porbandar Beach",
                        "Known for being the birthplace of Mahatma Gandhi.",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOSNcAS2JTQpob-0jRzkZHuNEyvUEP6QtRjg&s"
                    )
                )
            ),ParentItem.ParentTypeA(
                "ANDAMAN AND NICOBAR ISLANDS",
                listOf(
                    ChildItem.ChildTypeA("Radhanagar Beach", "Ranked as one of the best beaches in Asia for its pristine beauty.", "https://cdn.prod.website-files.com/5b56319971ac8c7475a9d877/5ee480f37d4707c269a7b5f9_radhanagar-beach-.jpg"),
                    ChildItem.ChildTypeA("Elephant Beach", "Known for its coral reefs and water sports.", "https://www.hotelbeachside.com/top-10-most-beautiful-beaches-in-andamannicobarislands/images/elephantbeach1.jpg"),
                    ChildItem.ChildTypeA("Corbyn’s Cove Beach", "A quiet beach with coconut trees and clear waters.", "https://static.toiimg.com/photo/36645925.cms"),
                    ChildItem.ChildTypeA("Vijaynagar Beach", "A beautiful beach ideal for swimming and relaxation.", "https://revolvingcompass.com/wp/wp-content/uploads/2019/10/VijaynagarBeach_3-min-1024x767.jpg?x42979"),
                    ChildItem.ChildTypeA("Kala Pathar Beach", "A peaceful beach with black rocks and turquoise waters.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5iVc48dqfoo01hPZaP2TOlGFexzRVZWt-Ba_LInL7VokZVPxnO7Bv0qQsTyEYLanMp1s&usqp=CAU"),
                    ChildItem.ChildTypeA("Laxmanpur Beach", "A pristine beach famous for its sunsets.", "https://www.trawell.in/admin/images/upload/171363139Andaman_Laxmanpur_Beach_Main.jpg"),
                    ChildItem.ChildTypeA("Bharatpur Beach", "Known for its shallow waters and coral reefs.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdM6-2z3i13ThMOfDO9iU1fdPAYmlO-W-pDL0dbEYLNNfMRl2j0pisxTBI1nUnJAkJwho&usqp=CAU")
                )
            ),

            ParentItem.ParentTypeA(
                "LAKSHADWEEP",
                listOf(
                    ChildItem.ChildTypeA("Bangaram Beach", "A beautiful beach with crystal-clear waters and soft sands.", "https://im.whatshot.in/img/2019/Feb/is-1551092082.jpg?wp=1"),
                    ChildItem.ChildTypeA("Agatti Beach", "A pristine beach known for its coral reefs and calm waters.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7tB1HO_AnNAb-mn9PiJvQya3BqrbXAt6TSz6FDgmqZAOfeAbiQal_9TTnc4Aj1M40oLA&usqp=CAU"),
                    ChildItem.ChildTypeA("Kadmat Beach", "A stunning beach known for its scuba diving spots.", "https://www.lakshadweeptour.in/images/kadmat-island-full-1.jpg"),
                    ChildItem.ChildTypeA("Kalpeni Beach", "A serene beach perfect for kayaking and water sports.", "https://cdn1.tripoto.com/media/filter/nl/img/2380291/Image/1702204015_1653554355images_27.jpeg.webp"),
                    ChildItem.ChildTypeA("Minicoy Beach", "A beautiful beach known for its lighthouse and stunning views.", "https://s.w-x.co/util/image/w/in-beach_4.jpg?v=at&w=815&h=458")
                    )
        )
        )


        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ParentAdapter(parentItems, this)
    }

    override fun onItemClick(childItem: ChildItem) {
        when (childItem) {
            is ChildItem.ChildTypeA -> {
                //  Toast.makeText(requireContext(), "Clicked: ${childItem.name}", Toast.LENGTH_SHORT).show()
            }

            is ChildItem.ChildTypeB -> {
                //  Toast.makeText(requireContext(), "Clicked: ${childItem.title}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
