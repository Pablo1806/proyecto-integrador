import React from "react";  


const useAPI = (url, method, body) => {
    const [response, setResponse] = React.useState(null);
    const [error, setError] = React.useState(null);
    const [loading, setLoading] = React.useState(false);
    
    React.useEffect(() => {
        const fetchData = async () => {
        setLoading(true);
        try {
            const res = await fetch(url, {
            method,
            body,
            headers: {
                "Content-Type": "application/json",
            },
            });
            const json = await res.json();
            setResponse(json);
            setLoading(false);
        } catch (error) {
            setError(error);
        }
        };
        fetchData();
    }, [url, method, body]);
    
    return { response, error, loading };
    
    };

export { useAPI };