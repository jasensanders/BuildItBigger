package com.example.jokes;

import java.util.Random;

public class JokeBuilder {

    public static final int NOUNLENGTH = 1525;
    public static final int REGVERBLENGTH = 634;
    public static final int IRREGVERBLENGTH = 91;
    public static final int ADJLENGTH = 1347;
    public static final int ADVERBLENGTH = 669;
    public static final int PPRONOUNLENGTH = 12;
    public static final int NUMJOKES = 2;

    public static final String NOUN = "NOUN";
    public static final String REGVERB = "REGVERB";
    public static final String IRREGVERB = "IRREGVERB";
    public static final String ADJECTIVE = "ADJECTIVE";
    public static final String ADVERB = "ADVERB";
    public static final String PPRONOUN = "PPRONOUN";

    Random scramble = new Random();

    public String randomJoke(){
        int choice = scramble.nextInt(NUMJOKES);
        String joke1 = "What did the " + randomWord(NOUN)+ " say to the " + randomWord(ADJECTIVE) + " " + randomWord(NOUN) + " ?"
                + "  He said,  you better " + randomWord(REGVERB) + " your " + randomWord(NOUN)+ ".  Ahahahaha I kill me!";
        String joke2 = "Why did the " + randomWord(NOUN) + " cross the road ? " + "To " + randomWord(REGVERB) + " the " + randomWord(NOUN) + " !";

        switch (choice){
            case 0:
                return joke1;
            case 1:
                return joke2;
            default:
                return joke1;
        }

    }

    public String randomWord(String type){
        int index = 0;
        String word = " ";
        switch (type){
            case NOUN:
                index = scramble.nextInt(NOUNLENGTH);
                word = getNoun(index);
                break;
            case REGVERB:
                index = scramble.nextInt(REGVERBLENGTH);
                word = getRegVerb(index);
                break;
            case IRREGVERB:
                index = scramble.nextInt(IRREGVERBLENGTH);
                word = getIrregVerb(index);
                break;
            case ADJECTIVE:
                index = scramble.nextInt(ADJLENGTH);
                word = getAdjective(index);
                break;
            case ADVERB:
                index = scramble.nextInt(ADVERBLENGTH);
                word = getAdverb(index);
                break;
            case PPRONOUN:
                index = scramble.nextInt(PPRONOUNLENGTH);
                word = getPPronoun(index);
                break;
            default:
                return "FooBar";
        }
        return word;

    }

    public static String getNoun (int index){
        //Ensures we will never get index out of range
        if(index > NOUNLENGTH-1){
            index = index%NOUNLENGTH;
        }
        //the Nouns
        String[] nouns = { "people", "history", "way", "art", "world", "information", "map", "two", "family", "government", "health",
                "system", "computer", "meat", "year", "thanks", "music", "person", "reading", "method", "data",
                "food", "understanding", "theory", "law", "bird", "literature", "problem", "software", "control", "knowledge",
                "power", "ability", "economics", "love", "internet", "television", "science", "library", "nature", "fact",
                "product", "idea", "temperature", "investment", "area", "society", "activity", "story", "industry", "media",
                "thing", "oven", "community", "definition", "safety", "quality", "development", "language", "management", "player",
                "variety", "video", "week", "security", "country", "exam", "movie", "organization", "equipment", "physics",
                "analysis", "policy", "series", "thought", "basis", "boyfriend", "direction", "strategy", "technology", "army",
                "camera", "freedom", "paper", "environment", "child", "instance", "month", "truth", "marketing", "university",
                "writing", "article", "department", "difference", "goal", "news", "audience", "fishing", "growth", "income",
                "marriage", "user", "combination", "failure", "meaning", "medicine", "philosophy", "teacher", "communication", "night",
                "chemistry", "disease", "disk", "energy", "nation", "road", "role", "soup", "advertising", "location",
                "success", "addition", "apartment", "education", "math", "moment", "painting", "politics", "attention", "decision",
                "event", "property", "shopping", "student", "wood", "competition", "distribution", "entertainment", "office", "population",
                "president", "unit", "category", "cigarette", "context", "introduction", "opportunity", "performance", "driver", "flight",
                "length", "magazine", "newspaper", "relationship", "teaching", "cell", "dealer", "finding", "lake", "member",
                "message", "phone", "scene", "appearance", "association", "concept", "customer", "death", "discussion", "housing",
                "inflation", "insurance", "mood", "woman", "advice", "blood", "effort", "expression", "importance", "opinion",
                "payment", "reality", "responsibility", "situation", "skill", "statement", "wealth", "application", "city", "county",
                "depth", "estate", "foundation", "grandmother", "heart", "perspective", "photo", "recipe", "studio", "topic",
                "collection", "depression", "imagination", "passion", "percentage", "resource", "setting", "ad", "agency", "college",
                "connection", "criticism", "debt", "description", "memory", "patience", "secretary", "solution", "administration", "aspect",
                "attitude", "director", "personality", "psychology", "recommendation", "response", "selection", "storage", "version", "alcohol",
                "argument", "complaint", "contract", "emphasis", "highway", "loss", "membership", "possession", "preparation", "steak",
                "union", "agreement", "cancer", "currency", "employment", "engineering", "entry", "interaction", "mixture", "preference",
                "region", "republic", "tradition", "virus", "actor", "classroom", "delivery", "device", "difficulty", "drama",
                "election", "engine", "football", "guidance", "hotel", "owner", "priority", "protection", "suggestion", "tension",
                "variation", "anxiety", "atmosphere", "awareness", "bath", "bread", "candidate", "climate", "comparison", "confusion",
                "construction", "elevator", "emotion", "employee", "employer", "guest", "height", "leadership", "mall", "manager",
                "operation", "recording", "sample", "transportation", "charity", "cousin", "disaster", "editor", "efficiency", "excitement",
                "extent", "feedback", "guitar", "homework", "leader", "mom", "outcome", "permission", "presentation", "promotion",
                "reflection", "refrigerator", "resolution", "revenue", "session", "singer", "tennis", "basket", "bonus", "cabinet",
                "childhood", "church", "clothes", "coffee", "dinner", "drawing", "hair", "hearing", "initiative", "judgment",
                "lab", "measurement", "mode", "mud", "orange", "poetry", "police", "possibility", "procedure", "queen",
                "ratio", "relation", "restaurant", "satisfaction", "sector", "signature", "significance", "song", "tooth", "town",
                "vehicle", "volume", "wife", "accident", "airport", "appointment", "arrival", "assumption", "baseball", "chapter",
                "committee", "conversation", "database", "enthusiasm", "error", "explanation", "farmer", "gate", "girl", "hall",
                "historian", "hospital", "injury", "instruction", "maintenance", "manufacturer", "meal", "perception", "pie", "poem",
                "presence", "proposal", "reception", "replacement", "revolution", "river", "son", "speech", "tea", "village",
                "warning", "winner", "worker", "writer", "assistance", "breath", "buyer", "chest", "chocolate", "conclusion",
                "contribution", "cookie", "courage", "dad", "desk", "drawer", "establishment", "examination", "garbage", "grocery",
                "honey", "impression", "improvement", "independence", "insect", "inspection", "inspector", "king", "ladder", "menu",
                "penalty", "piano", "potato", "profession", "professor", "quantity", "reaction", "requirement", "salad", "sister",
                "supermarket", "tongue", "weakness", "wedding", "affair", "ambition", "analyst", "apple", "assignment", "assistant",
                "bathroom", "bedroom", "beer", "birthday", "celebration", "championship", "cheek", "client", "consequence", "departure",
                "diamond", "dirt", "ear", "fortune", "friendship", "funeral", "gene", "girlfriend", "hat", "indication",
                "intention", "lady", "midnight", "negotiation", "obligation", "passenger", "pizza", "platform", "poet", "pollution",
                "recognition", "reputation", "shirt", "sir", "speaker", "stranger", "surgery", "sympathy", "tale", "throat",
                "trainer", "uncle", "youth", "time", "work", "film", "water", "money", "example", "while",
                "business", "study", "game", "life", "form", "air", "day", "place", "number", "part",
                "field", "fish", "back", "process", "heat", "hand", "experience", "job", "book", "end",
                "point", "type", "home", "economy", "value", "body", "market", "guide", "interest", "state",
                "radio", "course", "company", "price", "size", "card", "list", "mind", "trade", "line",
                "care", "group", "risk", "word", "fat", "force", "key", "light", "training", "name",
                "school", "top", "amount", "level", "order", "practice", "research", "sense", "service", "piece",
                "web", "boss", "sport", "fun", "house", "page", "term", "test", "answer", "sound",
                "focus", "matter", "kind", "soil", "board", "oil", "picture", "access", "garden", "range",
                "rate", "reason", "future", "site", "demand", "exercise", "image", "case", "cause", "coast",
                "action", "age", "bad", "boat", "record", "result", "section", "building", "mouse", "cash",
                "class", "nothing", "period", "plan", "store", "tax", "side", "subject", "space", "rule",
                "stock", "weather", "chance", "figure", "man", "model", "source", "beginning", "earth", "program",
                "chicken", "design", "feature", "head", "material", "purpose", "question", "rock", "salt", "act",
                "birth", "car", "dog", "object", "scale", "sun", "note", "profit", "rent", "speed",
                "style", "war", "bank", "craft", "half", "inside", "outside", "standard", "bus", "exchange",
                "eye", "fire", "position", "pressure", "stress", "advantage", "benefit", "box", "frame", "issue",
                "step", "cycle", "face", "item", "metal", "paint", "review", "room", "screen", "structure",
                "view", "account", "ball", "discipline", "medium", "share", "balance", "bit", "black", "bottom",
                "choice", "gift", "impact", "machine", "shape", "tool", "wind", "address", "average", "career",
                "culture", "morning", "pot", "sign", "table", "task", "condition", "contact", "credit", "egg",
                "hope", "ice", "network", "north", "square", "attempt", "date", "effect", "link", "post",
                "star", "voice", "capital", "challenge", "friend", "self", "shot", "brush", "couple", "debate",
                "exit", "front", "function", "lack", "living", "plant", "plastic", "spot", "summer", "taste",
                "theme", "track", "wing", "brain", "button", "click", "desire", "foot", "gas", "influence",
                "notice", "rain", "wall", "base", "damage", "distance", "feeling", "pair", "savings", "staff",
                "sugar", "target", "text", "animal", "author", "budget", "discount", "file", "ground", "lesson",
                "minute", "officer", "phase", "reference", "register", "sky", "stage", "stick", "title", "trouble",
                "bowl", "bridge", "campaign", "character", "club", "edge", "evidence", "fan", "letter", "lock",
                "maximum", "novel", "option", "pack", "park", "plenty", "quarter", "skin", "sort", "weight",
                "baby", "background", "carry", "dish", "factor", "fruit", "glass", "joint", "master", "muscle",
                "red", "strength", "traffic", "trip", "vegetable", "appeal", "chart", "gear", "ideal", "kitchen",
                "land", "log", "mother", "net", "party", "principle", "relative", "sale", "season", "signal",
                "spirit", "street", "tree", "wave", "belt", "bench", "commission", "copy", "drop", "minimum",
                "path", "progress", "project", "sea", "south", "status", "stuff", "ticket", "tour", "angle",
                "blue", "breakfast", "confidence", "daughter", "degree", "doctor", "dot", "dream", "duty", "essay",
                "father", "fee", "finance", "hour", "juice", "limit", "luck", "milk", "mouth", "peace",
                "pipe", "seat", "stable", "storm", "substance", "team", "trick", "afternoon", "bat", "beach",
                "blank", "catch", "chain", "consideration", "cream", "crew", "detail", "gold", "interview", "kid",
                "mark", "match", "mission", "pain", "pleasure", "score", "screw", "sex", "shop", "shower",
                "suit", "tone", "window", "agent", "band", "block", "bone", "calendar", "cap", "coat",
                "contest", "corner", "court", "cup", "district", "door", "east", "finger", "garage", "guarantee",
                "hole", "hook", "implement", "layer", "lecture", "lie", "manner", "meeting", "nose", "parking",
                "partner", "profile", "respect", "rice", "routine", "schedule", "swimming", "telephone", "tip", "winter",
                "airline", "bag", "battle", "bed", "bill", "bother", "cake", "code", "curve", "designer",
                "dimension", "dress", "ease", "emergency", "evening", "extension", "farm", "fight", "gap", "grade",
                "holiday", "horror", "horse", "host", "husband", "loan", "mistake", "mountain", "nail", "noise",
                "occasion", "package", "patient", "pause", "phrase", "proof", "race", "relief", "sand", "sentence",
                "shoulder", "smoke", "stomach", "string", "tourist", "towel", "vacation", "west", "wheel", "wine",
                "arm", "aside", "associate", "bet", "blow", "border", "branch", "breast", "brother", "buddy",
                "bunch", "chip", "coach", "cross", "document", "draft", "dust", "expert", "floor", "god",
                "golf", "habit", "iron", "judge", "knife", "landscape", "league", "mail", "mess", "native",
                "opening", "parent", "pattern", "pin", "pool", "pound", "request", "salary", "shame", "shelter",
                "shoe", "silver", "tackle", "tank", "trust", "assist", "bake", "bar", "bell", "bike",
                "blame", "boy", "brick", "chair", "closet", "clue", "collar", "comment", "conference", "devil",
                "diet", "fear", "fuel", "glove", "jacket", "lunch", "monitor", "mortgage", "nurse", "pace",
                "panic", "peak", "plane", "reward", "row", "sandwich", "shock", "spite", "spray", "surprise",
                "till", "transition", "weekend", "welcome", "yard", "alarm", "bend", "bicycle", "bite", "blind",
                "bottle", "cable", "candle", "clerk", "cloud", "concert", "counter", "flower", "grandfather", "harm",
                "knee", "lawyer", "leather", "load", "mirror", "neck", "pension", "plate", "purple", "ruin",
                "ship", "skirt", "slice", "snow", "specialist", "stroke", "switch", "trash", "tune", "zone",
                "anger", "award", "bid", "bitter", "boot", "bug", "camp", "candy", "carpet", "cat",
                "champion", "channel", "clock", "comfort", "cow", "crack", "engineer", "entrance", "fault", "grass",
                "guy", "hell", "highlight", "incident", "island", "joke", "jury", "leg", "lip", "mate",
                "motor", "nerve", "passage", "pen", "pride", "priest", "prize", "promise", "resident", "resort",
                "ring", "roof", "rope", "sail", "scheme", "script", "sock", "station", "toe", "tower",
                "truck", "witness", "a", "you", "it", "can", "will", "if", "one", "many",
                "most", "other", "use", "make", "good", "look", "help", "go", "great", "being",
                "few", "might", "still", "public", "read", "keep", "start", "give", "human", "local",
                "general", "she", "specific", "long", "play", "feel", "high", "tonight", "put", "common",
                "set", "change", "simple", "past", "big", "possible", "particular", "today", "major", "personal",
                "current", "national", "cut", "natural", "physical", "show", "try", "check", "second", "call",
                "move", "pay", "let", "increase", "single", "individual", "turn", "ask", "buy", "guard",
                "hold", "main", "offer", "potential", "professional", "international", "travel", "cook", "alternative", "following",
                "special", "working", "whole", "dance", "excuse", "cold", "commercial", "low", "purchase", "deal",
                "primary", "worth", "fall", "necessary", "positive", "produce", "search", "present", "spend", "talk",
                "creative", "tell", "cost", "drive", "green", "support", "glad", "remove", "return", "run",
                "complex", "due", "effective", "middle", "regular", "reserve", "independent", "leave", "original", "reach",
                "rest", "serve", "watch", "beautiful", "charge", "active", "break", "negative", "safe", "stay",
                "visit", "visual", "affect", "cover", "report", "rise", "walk", "white", "beyond", "junior",
                "pick", "unique", "anything", "classic", "final", "lift", "mix", "private", "stop", "teach",
                "western", "concern", "familiar", "fly", "official", "broad", "comfortable", "gain", "maybe", "rich",
                "save", "stand", "young", "fail", "heavy", "hello", "lead", "listen", "valuable", "worry",
                "handle", "leading", "meet", "release", "sell", "finish", "normal", "press", "ride", "secret",
                "spread", "spring", "tough", "wait", "brown", "deep", "display", "flow", "hit", "objective",
                "shoot", "touch", "cancel", "chemical", "cry", "dump", "extreme", "push", "conflict", "eat",
                "fill", "formal", "jump", "kick", "opposite", "pass", "pitch", "remote", "total", "treat",
                "vast", "abuse", "beat", "burn", "deposit", "print", "raise", "sleep", "somewhere", "advance",
                "anywhere", "consist", "dark", "double", "draw", "equal", "fix", "hire", "internal", "join",
                "kill", "sensitive", "tap", "win", "attack", "claim", "constant", "drag", "drink", "guess",
                "minor", "pull", "raw", "soft", "solid", "wear", "weird", "wonder", "annual", "count",
                "dead", "doubt", "feed", "forever", "impress", "nobody", "repeat", "round", "sing", "slide",
                "strip", "whereas", "wish", "combine", "command", "dig", "divide", "equivalent", "hang", "hunt",
                "initial", "march", "mention", "smell", "spiritual", "survey", "tie", "adult", "brief", "crazy",
                "escape", "gather", "hate", "prior", "repair", "rough", "sad", "scratch", "sick", "strike",
                "employ", "external", "hurt", "illegal", "laugh", "lay", "mobile", "nasty", "ordinary", "respond",
                "royal", "senior", "split", "strain", "struggle", "swim", "train", "upper", "wash", "yellow",
                "convert", "crash", "dependent", "fold", "funny", "grab", "hide", "miss", "permit", "quote",
                "recover", "resolve", "roll", "sink", "slip", "spare", "suspect", "sweet", "swing", "twist",
                "upstairs", "usual", "abroad", "brave", "calm", "concentrate", "estimate", "grand", "male", "mine",
                "prompt", "quiet", "refuse", "regret", "reveal", "rush", "shake", "shift", "shine", "steal",
                "suck", "surround", "anybody", "bear", "brilliant", "dare", "dear", "delay", "drunk", "female",
                "hurry", "inevitable", "invite", "kiss", "neat", "pop", "punch", "quit", "reply", "representative",
                "resist", "rip", "rub", "silly", "smile", "spell", "stretch", "stupid", "tear", "temporary",
                "tomorrow", "wake", "wrap", "yesterday" };

        return nouns[index];

    }

    public static String getRegVerb(int index){
        if (index > REGVERBLENGTH-1){
            index = index%REGVERBLENGTH;
        }

        String[] regVerbs = { "accept", "add", "admire", "admit", "advise", "afford", "agree", "alert", "allow", "amuse", "analyze",
                "announce", "annoy", "answer", "apologise", "appear", "applaud", "appreciate", "approve", "argue", "arrange",
                "arrest", "arrive", "ask", "attach", "attack", "attempt", "attend", "attract", "avoid", "back",
                "bake", "balance", "ban", "bang", "bare", "bat", "bathe", "battle", "beam", "beg",
                "behave", "belong", "bleach", "bless", "blind", "blink", "blot", "blush", "boast", "boil",
                "bolt", "bomb", "book", "bore", "borrow", "bounce", "bow", "box", "brake", "branch",
                "breathe", "bruise", "brush", "bubble", "bump", "burn", "bury", "buzz", "calculate", "call",
                "camp", "care", "carry", "carve", "cause", "challenge", "change", "charge", "chase", "cheat",
                "check", "cheer", "chew", "choke", "chop", "claim", "clap", "clean", "clear", "clip",
                "close", "coach", "coil", "collect", "colour", "comb", "command", "communicate", "compare", "compete",
                "complain", "complete", "concentrate", "concern", "confess", "confuse", "connect", "consider", "consist", "contain",
                "continue", "copy", "correct", "cough", "count", "cover", "crack", "crash", "crawl", "cross",
                "crush", "cry", "cure", "curl", "curve", "cycle", "dam", "damage", "dance", "dare",
                "decay", "deceive", "decide", "decorate", "delay", "delight", "deliver", "depend", "describe", "desert",
                "deserve", "destroy", "detect", "develop", "disagree", "disappear", "disapprove", "disarm", "discover", "dislike",
                "divide", "double", "doubt", "drag", "drain", "dream", "dress", "drip", "drop", "drown",
                "drum", "dry", "dust", "earn", "educate", "embarrass", "employ", "empty", "encourage", "end",
                "enjoy", "enter", "entertain", "escape", "examine", "excite", "excuse", "exercise", "exist", "expand",
                "expect", "explain", "explode", "extend", "face", "fade", "fail", "fancy", "fasten", "fax",
                "fear", "fence", "fetch", "file", "fill", "film", "fire", "fit", "fix", "flap",
                "flash", "float", "flood", "flow", "flower", "fold", "follow", "fool", "force", "form",
                "found", "frame", "frighten", "fry", "gather", "gaze", "glow", "glue", "grab", "grate",
                "grease", "greet", "grin", "grip", "groan", "guarantee", "guard", "guess", "guide", "hammer",
                "hand", "handle", "hang", "happen", "harass", "harm", "hate", "haunt", "head", "heal",
                "heap", "heat", "help", "hook", "hop", "hope", "hover", "hug", "hum", "hunt",
                "hurry", "identify", "ignore", "imagine", "impress", "improve", "include", "increase", "influence", "inform",
                "inject", "injure", "instruct", "intend", "interest", "interfere", "interrupt", "introduce", "invent", "invite",
                "irritate", "itch", "jail", "jam", "jog", "join", "joke", "judge", "juggle", "jump",
                "kick", "kill", "kiss", "kneel", "knit", "knock", "knot", "label", "land", "last",
                "laugh", "launch", "learn", "level", "license", "lick", "lie", "lighten", "like", "list",
                "listen", "live", "load", "lock", "long", "look", "love", "man", "manage", "march",
                "mark", "marry", "match", "mate", "matter", "measure", "meddle", "melt", "memorise", "mend",
                "mess", "up", "milk", "mine", "miss", "mix", "moan", "moor", "mourn", "move",
                "muddle", "mug", "multiply", "murder", "nail", "name", "need", "nest", "nod", "note",
                "notice", "number", "obey", "object", "observe", "obtain", "occur", "offend", "offer", "open",
                "order", "overflow", "owe", "own", "pack", "paddle", "paint", "park", "part", "pass",
                "paste", "pat", "pause", "peck", "pedal", "peel", "peep", "perform", "permit", "phone",
                "pick", "pinch", "pine", "place", "plan", "plant", "play", "please", "plug", "point",
                "poke", "polish", "pop", "possess", "post", "pour", "practice", "pray", "preach", "precede",
                "prefer", "prepare", "present", "preserve", "press", "pretend", "prevent", "prick", "print", "produce",
                "program", "promise", "protect", "provide", "pull", "pump", "punch", "puncture", "punish", "push",
                "question", "queue", "race", "radiate", "rain", "raise", "reach", "realise", "receive", "recognise",
                "record", "reduce", "reflect", "refuse", "regret", "reign", "reject", "rejoice", "relax", "release",
                "rely", "remain", "remember", "remind", "remove", "repair", "repeat", "replace", "reply", "report",
                "reproduce", "request", "rescue", "retire", "return", "rhyme", "rinse", "risk", "rob", "rock",
                "roll", "rot", "rub", "ruin", "rule", "rush", "sack", "sail", "satisfy", "save",
                "saw", "scare", "scatter", "scold", "scorch", "scrape", "scratch", "scream", "screw", "scribble",
                "scrub", "seal", "search", "separate", "serve", "settle", "shade", "share", "shave", "shelter",
                "shiver", "shock", "shop", "shrug", "sigh", "sign", "signal", "sin", "sip", "ski",
                "skip", "slap", "slip", "slow", "smash", "smell", "smile", "smoke", "snatch", "sneeze",
                "sniff", "snore", "snow", "soak", "soothe", "sound", "spare", "spark", "sparkle", "spell",
                "spill", "spoil", "spot", "spray", "sprout", "squash", "squeak", "squeal", "squeeze", "stain",
                "stamp", "stare", "start", "stay", "steer", "step", "stir", "stitch", "stop", "store",
                "strap", "strengthen", "stretch", "strip", "stroke", "stuff", "subtract", "succeed", "suck", "suffer",
                "suggest", "suit", "supply", "support", "suppose", "surprise", "surround", "suspect", "suspend", "switch",
                "talk", "tame", "tap", "taste", "tease", "telephone", "tempt", "terrify", "test", "thank",
                "thaw", "tick", "tickle", "tie", "time", "tip", "tire", "touch", "tour", "tow",
                "trace", "trade", "train", "transport", "trap", "travel", "treat", "tremble", "trick", "trip",
                "trot", "trouble", "trust", "try", "tug", "tumble", "turn", "twist", "type", "undress",
                "unfasten", "unite", "unlock", "unpack", "untidy", "use", "vanish", "visit", "wail", "wait",
                "walk", "wander", "want", "warm", "warn", "wash", "waste", "watch", "water", "wave",
                "weigh", "welcome", "whine", "whip", "whirl", "whisper", "whistle", "wink", "wipe", "wish",
                "wobble", "wonder", "work", "worry", "wrap", "wreck", "wrestle", "wriggle", "x-ray", "yawn",
                "yell", "zip", "zoom" };

        return regVerbs[index];
    }

    public static String getIrregVerb(int index){
        if(index > IRREGVERBLENGTH-1){
            index = index%IRREGVERBLENGTH;
        }

        String[] irregVerbs = { "awake", "be", "beat", "become", "begin", "bend", "bet", "bid", "bite", "blow", "break",
                "bring", "broadcast", "build", "burn", "buy", "catch", "choose", "come", "cost", "cut",
                "dig", "do", "draw", "dream", "drive", "drink", "eat", "fall", "feel", "fight",
                "find", "fly", "forget", "forgive", "freeze", "get", "give", "go", "grow", "hang",
                "have", "hear", "hide", "hit", "hold", "hurt", "keep", "know", "lay", "lead",
                "learn", "leave", "lend", "let", "lie", "lose", "make", "mean", "meet", "pay",
                "put", "read", "ride", "ring", "rise", "run", "say", "see", "sell", "send",
                "show", "shut", "sing", "sit", "sleep", "speak", "spend", "stand", "swim", "take",
                "teach", "tear", "tell", "think", "throw", "understand", "wake", "wear", "win", "write" };

        return irregVerbs[index];

    }

    public static String getAdjective(int index){
        if(index > ADJLENGTH-1){
            index = index%ADJLENGTH;
        }

        String[] adjectives = {"abandoned", "able", "absolute", "adorable", "adventurous", "academic", "acceptable", "acclaimed", "accomplished", "accurate", "aching",
                "acidic", "acrobatic", "active", "actual", "adept", "admirable", "admired", "adolescent", "adorable", "adored",
                "advanced", "afraid", "affectionate", "aged", "aggravating", "aggressive", "agile", "agitated", "agonizing", "agreeable",
                "ajar", "alarmed", "alarming", "alert", "alienated", "alive", "all", "altruistic", "amazing", "ambitious",
                "ample", "amused", "amusing", "anchored", "ancient", "angelic", "angry", "anguished", "animated", "annual",
                "another", "antique", "anxious", "any", "apprehensive", "appropriate", "apt", "arctic", "arid", "aromatic",
                "artistic", "ashamed", "assured", "astonishing", "athletic", "attached", "attentive", "attractive", "austere", "authentic",
                "authorized", "automatic", "avaricious", "average", "aware", "awesome", "awful", "awkward", "babyish", "bad",
                "back", "baggy", "bare", "barren", "basic", "beautiful", "belated", "beloved", "beneficial", "better",
                "best", "bewitched", "big", "big-hearted", "biodegradable", "bite-sized", "bitter", "black", "black-and-white", "bland",
                "blank", "blaring", "bleak", "blind", "blissful", "blond", "blue", "blushing", "bogus", "boiling",
                "bold", "bony", "boring", "bossy", "both", "bouncy", "bountiful", "bowed", "brave", "breakable",
                "brief", "bright", "brilliant", "brisk", "broken", "bronze", "brown", "bruised", "bubbly", "bulky",
                "bumpy", "buoyant", "burdensome", "burly", "bustling", "busy", "buttery", "buzzing", "calculating", "calm",
                "candid", "canine", "capital", "carefree", "careful", "careless", "caring", "cautious", "cavernous", "celebrated",
                "charming", "cheap", "cheerful", "cheery", "chief", "chilly", "chubby", "circular", "classic", "clean",
                "clear", "clear-cut", "clever", "close", "closed", "cloudy", "clueless", "clumsy", "cluttered", "coarse",
                "cold", "colorful", "colorless", "colossal", "comfortable", "common", "compassionate", "competent", "complete", "complex",
                "complicated", "composed", "concerned", "concrete", "confused", "conscious", "considerate", "constant", "content", "conventional",
                "cooked", "cool", "cooperative", "coordinated", "corny", "corrupt", "costly", "courageous", "courteous", "crafty",
                "crazy", "creamy", "creative", "creepy", "criminal", "crisp", "critical", "crooked", "crowded", "cruel",
                "crushing", "cuddly", "cultivated", "cultured", "cumbersome", "curly", "curvy", "cute", "cylindrical", "damaged",
                "damp", "dangerous", "dapper", "daring", "darling", "dark", "dazzling", "dead", "deadly", "deafening",
                "dear", "dearest", "decent", "decimal", "decisive", "deep", "defenseless", "defensive", "defiant", "deficient",
                "definite", "definitive", "delayed", "delectable", "delicious", "delightful", "delirious", "demanding", "dense", "dental",
                "dependable", "dependent", "descriptive", "deserted", "detailed", "determined", "devoted", "different", "difficult", "digital",
                "diligent", "dim", "dimpled", "dimwitted", "direct", "disastrous", "discrete", "disfigured", "disgusting", "disloyal",
                "dismal", "distant", "downright", "dreary", "dirty", "disguised", "dishonest", "dismal", "distant", "distinct",
                "distorted", "dizzy", "dopey", "doting", "double", "downright", "drab", "drafty", "dramatic", "dreary",
                "droopy", "dry", "dual", "dull", "dutiful", "each", "eager", "earnest", "early", "easy",
                "easy-going", "ecstatic", "edible", "educated", "elaborate", "elastic", "elated", "elderly", "electric", "elegant",
                "elementary", "elliptical", "embarrassed", "embellished", "eminent", "emotional", "empty", "enchanted", "enchanting", "energetic",
                "enlightened", "enormous", "enraged", "entire", "envious", "equal", "equatorial", "essential", "esteemed", "ethical",
                "euphoric", "even", "evergreen", "everlasting", "every", "evil", "exalted", "excellent", "exemplary", "exhausted",
                "excitable", "excited", "exciting", "exotic", "expensive", "experienced", "expert", "extraneous", "extroverted", "extra-large",
                "extra-small", "fabulous", "failing", "faint", "fair", "faithful", "fake", "false", "familiar", "famous",
                "fancy", "fantastic", "far", "faraway", "far-flung", "far-off", "fast", "fat", "fatal", "fatherly",
                "favorable", "favorite", "fearful", "fearless", "feisty", "feline", "female", "feminine", "few", "fickle",
                "filthy", "fine", "finished", "firm", "first", "firsthand", "fitting", "fixed", "flaky", "flamboyant",
                "flashy", "flat", "flawed", "flawless", "flickering", "flimsy", "flippant", "flowery", "fluffy", "fluid",
                "flustered", "focused", "fond", "foolhardy", "foolish", "forceful", "forked", "formal", "forsaken", "forthright",
                "fortunate", "fragrant", "frail", "frank", "frayed", "free", "French", "fresh", "frequent", "friendly",
                "frightened", "frightening", "frigid", "frilly", "frizzy", "frivolous", "front", "frosty", "frozen", "frugal",
                "fruitful", "full", "fumbling", "functional", "funny", "fussy", "fuzzy", "gargantuan", "gaseous", "general",
                "generous", "gentle", "genuine", "giant", "giddy", "gigantic", "gifted", "giving", "glamorous", "glaring",
                "glass", "gleaming", "gleeful", "glistening", "glittering", "gloomy", "glorious", "glossy", "glum", "golden",
                "good", "good-natured", "gorgeous", "graceful", "gracious", "grand", "grandiose", "granular", "grateful", "grave",
                "gray", "great", "greedy", "green", "gregarious", "grim", "grimy", "gripping", "grizzled", "gross",
                "grotesque", "grouchy", "grounded", "growing", "growling", "grown", "grubby", "gruesome", "grumpy", "guilty",
                "gullible", "gummy", "hairy", "half", "handmade", "handsome", "handy", "happy", "happy-go-lucky", "hard",
                "hard-to-find", "harmful", "harmless", "harmonious", "harsh", "hasty", "hateful", "haunting", "healthy", "heartfelt",
                "hearty", "heavenly", "heavy", "hefty", "helpful", "helpless", "hidden", "hideous", "high", "high-level",
                "hilarious", "hoarse", "hollow", "homely", "honest", "honorable", "honored", "hopeful", "horrible", "hospitable",
                "hot", "huge", "humble", "humiliating", "humming", "humongous", "hungry", "hurtful", "husky", "icky",
                "icy", "ideal", "idealistic", "identical", "idle", "idiotic", "idolized", "ignorant", "ill", "illegal",
                "ill-fated", "ill-informed", "illiterate", "illustrious", "imaginary", "imaginative", "immaculate", "immaterial", "immediate", "immense",
                "impassioned", "impeccable", "impartial", "imperfect", "imperturbable", "impish", "impolite", "important", "impossible", "impractical",
                "impressionable", "impressive", "improbable", "impure", "inborn", "incomparable", "incompatible", "incomplete", "inconsequential", "incredible",
                "indelible", "inexperienced", "indolent", "infamous", "infantile", "infatuated", "inferior", "infinite", "informal", "innocent",
                "insecure", "insidious", "insignificant", "insistent", "instructive", "insubstantial", "intelligent", "intent", "intentional", "interesting",
                "internal", "international", "intrepid", "ironclad", "irresponsible", "irritating", "itchy", "jaded", "jagged", "jam-packed",
                "jaunty", "jealous", "jittery", "joint", "jolly", "jovial", "joyful", "joyous", "jubilant", "judicious",
                "juicy", "jumbo", "junior", "jumpy", "juvenile", "kaleidoscopic", "keen", "key", "kind", "kindhearted",
                "kindly", "klutzy", "knobby", "knotty", "knowledgeable", "knowing", "known", "kooky", "kosher", "lame",
                "lanky", "large", "last", "lasting", "late", "lavish", "lawful", "lazy", "leading", "lean",
                "leafy", "left", "legal", "legitimate", "light", "lighthearted", "likable", "likely", "limited", "limp",
                "limping", "linear", "lined", "liquid", "little", "live", "lively", "livid", "loathsome", "lone",
                "lonely", "long", "long-term", "loose", "lopsided", "lost", "loud", "lovable", "lovely", "loving",
                "low", "loyal", "lucky", "lumbering", "luminous", "lumpy", "lustrous", "luxurious", "mad", "made-up",
                "magnificent", "majestic", "major", "male", "mammoth", "married", "marvelous", "masculine", "massive", "mature",
                "meager", "mealy", "mean", "measly", "meaty", "medical", "mediocre", "medium", "meek", "mellow",
                "melodic", "memorable", "menacing", "merry", "messy", "metallic", "mild", "milky", "mindless", "miniature",
                "minor", "minty", "miserable", "miserly", "misguided", "misty", "mixed", "modern", "modest", "moist",
                "monstrous", "monthly", "monumental", "moral", "mortified", "motherly", "motionless", "mountainous", "muddy", "muffled",
                "multicolored", "mundane", "murky", "mushy", "musty", "muted", "mysterious", "naive", "narrow", "nasty",
                "natural", "naughty", "nautical", "near", "neat", "necessary", "needy", "negative", "neglected", "negligible",
                "neighboring", "nervous", "new", "next", "nice", "nifty", "nimble", "nippy", "nocturnal", "noisy",
                "nonstop", "normal", "notable", "noted", "noteworthy", "novel", "noxious", "numb", "nutritious", "nutty",
                "obedient", "obese", "oblong", "oily", "oblong", "obvious", "occasional", "odd", "oddball", "offbeat",
                "offensive", "official", "old", "old-fashioned", "only", "open", "optimal", "optimistic", "opulent", "orange",
                "orderly", "organic", "ornate", "ornery", "ordinary", "original", "other", "our", "outlying", "outgoing",
                "outlandish", "outrageous", "outstanding", "oval", "overcooked", "overdue", "overjoyed", "overlooked", "palatable", "pale",
                "paltry", "parallel", "parched", "partial", "passionate", "past", "pastel", "peaceful", "peppery", "perfect",
                "perfumed", "periodic", "perky", "personal", "pertinent", "pesky", "pessimistic", "petty", "phony", "physical",
                "piercing", "pink", "pitiful", "plain", "plaintive", "plastic", "playful", "pleasant", "pleased", "pleasing",
                "plump", "plush", "polished", "polite", "political", "pointed", "pointless", "poised", "poor", "popular",
                "portly", "posh", "positive", "possible", "potable", "powerful", "powerless", "practical", "precious", "present",
                "prestigious", "pretty", "precious", "previous", "pricey", "prickly", "primary", "prime", "pristine", "private",
                "prize", "probable", "productive", "profitable", "profuse", "proper", "proud", "prudent", "punctual", "pungent",
                "puny", "pure", "purple", "pushy", "putrid", "puzzled", "puzzling", "quaint", "qualified", "quarrelsome",
                "quarterly", "queasy", "querulous", "questionable", "quick", "quick-witted", "quiet", "quintessential", "quirky", "quixotic",
                "quizzical", "radiant", "ragged", "rapid", "rare", "rash", "raw", "recent", "reckless", "rectangular",
                "ready", "real", "realistic", "reasonable", "red", "reflecting", "regal", "regular", "reliable", "relieved",
                "remarkable", "remorseful", "remote", "repentant", "required", "respectful", "responsible", "repulsive", "revolving", "rewarding",
                "rich", "rigid", "right", "ringed", "ripe", "roasted", "robust", "rosy", "rotating", "rotten",
                "rough", "round", "rowdy", "royal", "rubbery", "rundown", "ruddy", "rude", "runny", "rural",
                "rusty", "sad", "safe", "salty", "same", "sandy", "sane", "sarcastic", "sardonic", "satisfied",
                "scaly", "scarce", "scared", "scary", "scented", "scholarly", "scientific", "scornful", "scratchy", "scrawny",
                "second", "secondary", "second-hand", "secret", "self-assured", "self-reliant", "selfish", "sentimental", "separate", "serene",
                "serious", "serpentine", "several", "severe", "shabby", "shadowy", "shady", "shallow", "shameful", "shameless",
                "sharp", "shimmering", "shiny", "shocked", "shocking", "shoddy", "short", "short-term", "showy", "shrill",
                "shy", "sick", "silent", "silky", "silly", "silver", "similar", "simple", "simplistic", "sinful",
                "single", "sizzling", "skeletal", "skinny", "sleepy", "slight", "slim", "slimy", "slippery", "slow",
                "slushy", "small", "smart", "smoggy", "smooth", "smug", "snappy", "snarling", "sneaky", "sniveling",
                "snoopy", "sociable", "soft", "soggy", "solid", "somber", "some", "spherical", "sophisticated", "sore",
                "sorrowful", "soulful", "soupy", "sour", "Spanish", "sparkling", "sparse", "specific", "spectacular", "speedy",
                "spicy", "spiffy", "spirited", "spiteful", "splendid", "spotless", "spotted", "spry", "square", "squeaky",
                "squiggly", "stable", "staid", "stained", "stale", "standard", "starchy", "stark", "starry", "steep",
                "sticky", "stiff", "stimulating", "stingy", "stormy", "straight", "strange", "steel", "strict", "strident",
                "striking", "striped", "strong", "studious", "stunning", "stupendous", "stupid", "sturdy", "stylish", "subdued",
                "submissive", "substantial", "subtle", "suburban", "sudden", "sugary", "sunny", "super", "superb", "superficial",
                "superior", "supportive", "sure-footed", "surprised", "suspicious", "svelte", "sweaty", "sweet", "sweltering", "swift",
                "sympathetic", "tall", "talkative", "tame", "tan", "tangible", "tart", "tasty", "tattered", "taut",
                "tedious", "teeming", "tempting", "tender", "tense", "tepid", "terrible", "terrific", "testy", "thankful",
                "that", "these", "thick", "thin", "third", "thirsty", "this", "thorough", "thorny", "those",
                "thoughtful", "threadbare", "thrifty", "thunderous", "tidy", "tight", "timely", "tinted", "tiny", "tired",
                "torn", "total", "tough", "traumatic", "treasured", "tremendous", "tragic", "trained", "tremendous", "triangular",
                "tricky", "trifling", "trim", "trivial", "troubled", "true", "trusting", "trustworthy", "trusty", "truthful",
                "tubby", "turbulent", "twin", "ugly", "ultimate", "unacceptable", "unaware", "uncomfortable", "uncommon", "unconscious",
                "understated", "unequaled", "uneven", "unfinished", "unfit", "unfolded", "unfortunate", "unhappy", "unhealthy", "uniform",
                "unimportant", "unique", "united", "unkempt", "unknown", "unlawful", "unlined", "unlucky", "unnatural", "unpleasant",
                "unrealistic", "unripe", "unruly", "unselfish", "unsightly", "unsteady", "unsung", "untidy", "untimely", "untried",
                "untrue", "unused", "unusual", "unwelcome", "unwieldy", "unwilling", "unwitting", "unwritten", "upbeat", "upright",
                "upset", "urban", "usable", "used", "useful", "useless", "utilized", "utter", "vacant", "vague",
                "vain", "valid", "valuable", "vapid", "variable", "vast", "velvety", "venerated", "vengeful", "verifiable",
                "vibrant", "vicious", "victorious", "vigilant", "vigorous", "villainous", "violet", "violent", "virtual", "virtuous",
                "visible", "vital", "vivacious", "vivid", "voluminous", "wan", "warlike", "warm", "warmhearted", "warped",
                "wary", "wasteful", "watchful", "waterlogged", "watery", "wavy", "wealthy", "weak", "weary", "webbed",
                "wee", "weekly", "weepy", "weighty", "weird", "welcome", "well-documented", "well-groomed", "well-informed", "well-lit",
                "well-made", "well-off", "well-to-do", "well-worn", "wet", "which", "whimsical", "whirlwind", "whispered", "white",
                "whole", "whopping", "wicked", "wide", "wide-eyed", "wiggly", "wild", "willing", "wilted", "winding",
                "windy", "winged", "wiry", "wise", "witty", "wobbly", "woeful", "wonderful", "wooden", "woozy",
                "wordy", "worldly", "worn", "worried", "worrisome", "worse", "worst", "worthless", "worthwhile", "worthy",
                "wrathful", "wretched", "writhing", "wrong", "wry", "yawning", "yearly", "yellow", "yellowish", "young",
                "youthful", "yummy", "zany", "zealous", "zesty", "zigzag" };

        return adjectives[index];
    }

    public static String getAdverb(int index){
        if(index > ADVERBLENGTH-1){
            index = index%ADVERBLENGTH;
        }

        String[] adverbs = {"aboard", "abnormally", "about", "abroad", "absentmindedly", "absolutely", "abundantly", "accidentally", "accordingly", "actively", "actually",
                "acutely", "admiringly", "affectionately", "affirmatively", "after", "afterwards", "agreeably", "almost", "already", "always",
                "amazingly", "angrily", "annoyingly", "annually", "anxiously", "anyhow", "anyplace", "anyway", "anywhere", "appreciably",
                "appropriately", "around", "arrogantly", "aside", "assuredly", "astonishingly", "away", "awfully", "awkwardly", "badly",
                "barely", "bashfully", "beautifully", "before", "begrudgingly", "believably", "bewilderedly", "bewilderingly", "bitterly", "bleakly",
                "blindly", "blissfully", "boldly", "boastfully", "boldly", "boyishly", "bravely", "briefly", "brightly", "brilliantly",
                "briskly", "brutally", "busily", "calmly", "candidly", "carefully", "carelessly", "casually", "cautiously", "certainly",
                "charmingly", "cheerfully", "chiefly", "childishly", "cleanly", "clearly", "cleverly", "closely", "cloudily", "clumsily",
                "coaxingly", "coincidentally", "coldly", "colorfully", "commonly", "comfortably", "compactly", "compassionately", "completely", "confusedly",
                "consequently", "considerably", "considerately", "consistently", "constantly", "continually", "continuously", "coolly", "correctly", "courageously",
                "covertly", "cowardly", "crazily", "crossly", "cruelly", "cunningly", "curiously", "currently", "customarily", "cutely",
                "daily", "daintily", "dangerously", "daringly", "darkly", "dastardly", "dearly", "decently", "deeply", "defiantly",
                "deftly", "deliberately", "delicately", "delightfully", "densely", "diagonally", "differently", "diligently", "dimly", "directly",
                "disorderly", "divisively", "docilely", "dopily", "doubtfully", "down", "dramatically", "dreamily", "during", "eagerly",
                "early", "earnestly", "easily", "efficiently", "effortlessly", "elaborately", "eloquently", "elegantly", "elsewhere", "emotionally",
                "endlessly", "energetically", "enjoyably", "enormously", "enough", "enthusiastically", "entirely", "equally", "especially", "essentially",
                "eternally", "ethically", "even", "evenly", "eventually", "evermore", "every", "everywhere", "evidently", "evocatively",
                "exactly", "exceedingly", "exceptionally", "excitedly", "exclusively", "explicitly", "expressly", "extensively", "externally", "extra",
                "extraordinarily", "extremely", "fairly", "faithfully", "famously", "far", "fashionably", "fast", "fatally", "favorably",
                "ferociously", "fervently", "fiercely", "fiery", "finally", "financially", "finitely", "fluently", "fondly", "foolishly",
                "forever", "formally", "formerly", "fortunately", "forward", "frankly", "frantically", "freely", "frequently", "frenetically",
                "fully", "furiously", "furthermore", "generally", "generously", "genuinely", "gently", "genuinely", "girlishly", "gladly",
                "gleefully", "gracefully", "graciously", "gradually", "gratefully", "greatly", "greedily", "grimly", "grudgingly", "habitually",
                "half-heartedly", "handily", "handsomely", "haphazardly", "happily", "hastily", "harmoniously", "harshly", "hastily", "hatefully",
                "hauntingly", "healthily", "heartily", "heavily", "helpfully", "hence", "highly", "hitherto", "honestly", "hopelessly",
                "horizontally", "hourly", "how", "however", "hugely", "humorously", "hungrily", "hurriedly", "hysterically", "icily",
                "identifiably", "idiotically", "imaginatively", "immeasurably", "immediately", "immensely", "impatiently", "impressively", "inappropriately", "incessantly",
                "incorrectly", "indeed", "independently", "indoors", "indubitably", "inevitably", "infinitely", "informally", "infrequently", "innocently",
                "inquisitively", "instantly", "intelligently", "intensely", "intently", "interestingly", "intermittently", "internally", "invariably", "invisibly",
                "inwardly", "ironically", "irrefutably", "irritably", "jaggedly", "jauntily", "jealously", "jovially", "joyfully", "joylessly",
                "joyously", "jubilantly", "judgmentally", "just", "justly", "keenly", "kiddingly", "kindheartedly", "kindly", "knavishly",
                "knottily", "knowingly", "knowledgeably", "kookily", "lastly", "late", "lately", "later", "lazily", "less",
                "lightly", "likely", "limply", "lithely", "lively", "loftily", "longingly", "loosely", "loudly", "lovingly",
                "loyally", "luckily", "luxuriously", "madly", "magically", "mainly", "majestically", "markedly", "materially", "meaningfully",
                "meanly", "meantime", "meanwhile", "measurably", "mechanically", "medically", "menacingly", "merely", "merrily", "methodically",
                "mightily", "miserably", "mockingly", "monthly", "morally", "more", "moreover", "mortally", "mostly", "much",
                "mysteriously", "nastily", "naturally", "naughtily", "nearby", "nearly", "neatly", "needily", "negatively", "nervously",
                "never", "nevertheless", "next", "nicely", "nightly", "noisily", "normally", "nosily", "not", "now",
                "nowadays", "numbly", "obediently", "obligingly", "obnoxiously", "obviously", "occasionally", "oddly", "offensively", "officially",
                "often", "ominously", "once", "only", "openly", "optimistically", "orderly", "ordinarily", "outdoors", "outrageously",
                "outwardly", "outwards", "overconfidently", "overseas", "painfully", "painlessly", "paradoxically", "partially", "particularly", "passionately",
                "patiently", "perfectly", "periodically", "perpetually", "persistently", "personally", "persuasively", "physically", "plainly", "playfully",
                "poetically", "poignantly", "politely", "poorly", "positively", "possibly", "potentially", "powerfully", "presently", "presumably",
                "prettily", "previously", "primly", "principally", "probably", "promptly", "properly", "proudly", "punctually", "puzzlingly",
                "quaintly", "queasily", "questionably", "questioningly", "quicker", "quickly", "quietly", "quirkily", "quite", "quizzically",
                "randomly", "rapidly", "rarely", "readily", "really", "reasonably", "reassuringly", "recently", "recklessly", "regularly",
                "reliably", "reluctantly", "remarkably", "repeatedly", "reproachfully", "reponsibly", "resentfully", "respectably", "respectfully", "restfully",
                "richly", "ridiculously", "righteously", "rightfully", "rightly", "rigidly", "roughly", "routinely", "rudely", "ruthlessly",
                "sadly", "safely", "scarcely", "scarily", "scientifically", "searchingly", "secretively", "securely", "sedately", "seemingly",
                "seldom", "selfishly", "selflessly", "separately", "seriously", "shakily", "shamelessly", "sharply", "sheepishly", "shoddily",
                "shortly", "shrilly", "significantly", "silently", "simply", "sincerely", "singularly", "shyly", "skillfully", "sleepily",
                "slightly", "slowly", "slyly", "smoothly", "so", "softly", "solely", "solemnly", "solidly", "silicitiously",
                "somehow", "sometimes", "somewhat", "somewhere", "soon", "specially", "specifically", "spectacularly", "speedily", "spiritually",
                "splendidly", "sporadically", "spasmodically", "startlingly", "steadily", "stealthily", "sternly", "still", "strenuously", "stressfully",
                "strictly", "structurally", "studiously", "stupidly", "stylishly", "subsequently", "substantially", "subtly", "successfully", "suddenly",
                "sufficiently", "suitably", "superficially", "supremely", "surely", "surprisingly", "suspiciously", "sweetly", "swiftly", "sympathetically",
                "systematically", "temporarily", "tenderly", "tensely", "tepidly", "terribly", "thankfully", "then", "there", "thereby",
                "thoroughly", "thoughtfully", "thus", "tightly", "today", "together", "tomorrow", "too", "totally", "touchingly",
                "tremendously", "truly", "truthfully", "twice", "ultimately", "unabashedly", "unanimously", "unbearably", "unbelievably", "unemotionally",
                "unethically", "unexpectedly", "unfailingly", "unfavorably", "unfortunately", "uniformly", "unilaterally", "unimpressively", "universally", "unnaturally",
                "unnecessarily", "unquestionably", "unwillingly", "up", "upbeat", "unkindly", "upliftingly", "upright", "unselfishly", "upside-down",
                "unskillfully", "upward", "upwardly", "urgently", "usefully", "uselessly", "usually", "utterly", "vacantly", "vaguely",
                "vainly", "valiantly", "vastly", "verbally", "vertically", "very", "viciously", "victoriously", "vigilantly", "vigorously",
                "violently", "visibly", "visually", "vivaciously", "voluntarily", "warmly", "weakly", "wearily", "weekly", "well",
                "wetly", "when", "where", "while", "whole-heartedly", "wholly", "why", "wickedly", "widely", "wiggly",
                "wildly", "willfully", "willingly", "wisely", "woefully", "wonderfully", "worriedly", "worthily", "wrongly", "yearly",
                "yearningly", "yesterday", "yet", "youthfully", "zanily", "zealously", "zestfully", "zestily" };

        return adverbs[index];
    }

    public static String getPPronoun(int index){
        if(index > PPRONOUNLENGTH-1){
            index = index%PPRONOUNLENGTH;
        }

        String[] personalPronouns = { "I", "me", "you", "he", "she", "it", "him", "her", "us", "we", "they",
                "them " };
        return personalPronouns[index];
    }


}
